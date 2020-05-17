package fun.oook.lottery.job.task;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import fun.oook.lottery.commons.config.RedisKeys;
import fun.oook.lottery.commons.db.entity.*;
import fun.oook.lottery.commons.db.mapper.CardGameMapper;
import fun.oook.lottery.commons.db.mapper.CardGameProductMapper;
import fun.oook.lottery.commons.db.mapper.CardGameRulesMapper;
import fun.oook.lottery.commons.db.mapper.GameLoadMapper;
import fun.oook.lottery.commons.util.RedisUtil;
import fun.oook.lottery.job.annotation.SimpleElasticJob;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.*;

/**
 * @author ZhouYu
 * @since 0.0.1
 */
@Component
@SimpleElasticJob(cron = "0 * * * * ?")
public class GameTask implements SimpleJob {

    private final static Logger log = LoggerFactory.getLogger(GameTask.class);

    @Resource
    private CardGameMapper gameMapper;

    @Resource
    private CardGameProductMapper gameProductMapper;

    @Resource
    private CardGameRulesMapper gameRulesMapper;

    @Resource
    private GameLoadMapper gameLoadMapper;

    @Resource
    private RedisUtil redisUtil;

    @Override
    public void execute(final ShardingContext shardingContext) {
        // 记录当前时间
        final Date now = new Date();
        // 查询将来一分钟内要开始的活动
        final CardGameExample gameExample = new CardGameExample();
        gameExample.createCriteria()
                .andStarttimeGreaterThan(now)
                .andStarttimeLessThanOrEqualTo(DateUtils.addMinutes(now, 1));

        final List<CardGame> gameList = gameMapper.selectByExample(gameExample);
        log.info("game list scan: size = {}", gameList.size());
        if (CollectionUtils.isEmpty(gameList)) {
            // 没有要开始的活动，直接跳过
            return;
        }
        // 将活动数据预热，存入redis
        gameList.forEach(game -> {
            final Integer gameId = game.getId();
            final long start = game.getStarttime().getTime();
            final long end = game.getEndtime().getTime();
            final long expire = (end - now.getTime()) / 1000;
            final long duration = end - start;

            game.setStatus((byte) 1);
            redisUtil.set(RedisKeys.GAME_INFO + gameId, game, -1);
            log.info("load game info: {},{},{},{}", gameId, game.getTitle(), game.getStarttime(), game.getEndtime());

            // 活动奖品信息
            final List<CardProductDTO> products = gameLoadMapper.getByGameId(gameId);
            final Map<Integer, CardProduct> productMap = new HashMap<>(products.size());
            products.forEach(p -> productMap.put(p.getId(), p));
            log.info("load product type:{}", productMap.size());

            // 奖品数量等配置信息
            final CardGameProductExample productExample = new CardGameProductExample();
            productExample.createCriteria().andGameidEqualTo(gameId);
            final List<CardGameProduct> gameProducts = gameProductMapper.selectByExample(productExample);
            log.info("load bind product:{}", gameProducts.size());

            // 令牌桶
            final List<Long> tokenList = new ArrayList<>();
            gameProducts.forEach(gp -> {
                for (int i = 0; i < gp.getAmount(); i++) {
                    // 生成amount个start到end之间的随机时间戳作为令牌
                    long token = start + new Random().nextInt((int) duration);
                    // 追加随机值，降低token重复率（TODO 需要使用时间戳时要进行还原操作）
                    token = token * 1000 + new Random().nextInt(999);
                    tokenList.add(token);

                    log.info("token -> game : {} -> {}", token / 1000, productMap.get(gp.getProductid()).getName());

                    redisUtil.set(RedisKeys.GAME_TOKEN + gameId + "_" + token,
                            productMap.get(gp.getProductid()), expire);
                }
            });
            // token排序后存入redis队列
            Collections.sort(tokenList);
            log.info("load tokens: {}", tokenList);

            // 从右侧压入队列，从左到右，时间戳逐个增大
            redisUtil.rightPushAll(RedisKeys.GAME_TOKENS + gameId, tokenList);
            redisUtil.expire(RedisKeys.GAME_TOKENS + gameId, expire);

            // 奖品策略配置信息
            final CardGameRulesExample rulesExample = new CardGameRulesExample();
            rulesExample.createCriteria().andGameidEqualTo(gameId);
            final List<CardGameRules> rules = gameRulesMapper.selectByExample(rulesExample);
            rules.forEach(r -> {
                redisUtil.hset(RedisKeys.GAME_MAX_GOAL + gameId, r.getUserlevel() + "", r.getGoalTimes());
                redisUtil.hset(RedisKeys.GAME_MAX_ENTER + gameId, r.getUserlevel() + "", r.getEnterTimes());
                log.info("load rule: level={},enter={},goal={}", r.getUserlevel(), r.getGoalTimes(), r.getEnterTimes());
            });
            redisUtil.expire(RedisKeys.GAME_MAX_GOAL + gameId, expire);
            redisUtil.expire(RedisKeys.GAME_MAX_ENTER + gameId, expire);

            // 活动状态变更为已预热，禁止管理后台随意变动
            game.setStatus((byte) 1);
            gameMapper.updateByPrimaryKey(game);
        });
    }
}
