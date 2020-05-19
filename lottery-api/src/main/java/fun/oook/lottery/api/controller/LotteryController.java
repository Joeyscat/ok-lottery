package fun.oook.lottery.api.controller;

import fun.oook.lottery.api.coonfig.LuaScript;
import fun.oook.lottery.api.service.CardGameService;
import fun.oook.lottery.commons.config.RabbitKeys;
import fun.oook.lottery.commons.config.RedisKeys;
import fun.oook.lottery.commons.db.entity.*;
import fun.oook.lottery.commons.util.ApiResult;
import fun.oook.lottery.commons.util.RedisUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ZhouYu
 * @since 0.0.1
 */
@RestController
@RequestMapping("/api/activity")
@Api(tags = "抽奖模块")
public class LotteryController {
    private static final Logger log = LoggerFactory.getLogger(LotteryController.class);

    @Resource
    private CardGameService cardGameService;

    @Resource
    private RedisUtil redisUtil;

    @Resource
    private RabbitTemplate rabbitTemplate;

    @Resource
    private LuaScript luaScript;

    @GetMapping("/go/{game_id}")
    @ApiOperation("抽奖")
    @ApiImplicitParam(name = "game_id", value = "活动id", example = "1", required = true)
    public ApiResult<Object> lottery(@PathVariable("game_id") final int gameId,
                                     final HttpServletRequest req) {
        final HttpSession session = req.getSession();
        final CardUser user = (CardUser) redisUtil.get(RedisKeys.USER_SESSION_ID + session.getId());
        if (user == null) {
            return new ApiResult<>(-1, "未登录", null);
        }

        final Date now = new Date();
        final CardGame game = (CardGame) redisUtil.get(RedisKeys.GAME_INFO + gameId);

        if (game == null || game.getStarttime().after(now)) {
            // 活动信息未预热/活动未开始
            return new ApiResult<>(-1, "活动未开始", null);
        }
        if (now.after(game.getEndtime())) {
            // 活动已结束
            return new ApiResult<>(-1, "活动已结束", null);
        }

        final Integer userId = user.getId();
        if (!redisUtil.hasKey(RedisKeys.USER_GAME + userId + "_" + gameId)) {
            redisUtil.set(RedisKeys.USER_GAME + userId + "_" + gameId, 1, (game.getEndtime().getTime() - now.getTime()) / 1000);
            // 持久化抽奖记录，交给消息队列处理
            final CardUserGame userGame = new CardUserGame();
            userGame.setUserId(userId);
            userGame.setGameId(gameId);
            userGame.setCreatedTime(new Date());
            rabbitTemplate.convertAndSend(RabbitKeys.QUEUE_PLAY, userGame);
        }
        // 用户已中奖次数
        final Object c = redisUtil.get(RedisKeys.USER_HIT + gameId + "_" + userId);
        Integer count = c == null ? null : Integer.parseInt((String.valueOf(c)));
        if (count == null) {
            count = 0;
            redisUtil.set(RedisKeys.USER_HIT + game + "_" + userId, count, (game.getEndtime().getTime() - now.getTime()) / 1000);
        }
        // 根据会员等级，获取中奖上限
        final Object maxGoal = redisUtil.hget(RedisKeys.GAME_MAX_GOAL + gameId, Integer.toString(user.getLevel()));
        int maxCount = maxGoal == null ? 0 : Integer.parseInt(String.valueOf(maxGoal));
        if (maxCount > 0 && count >= maxCount) {
            // 达到最大中奖数，不再允许抽奖
            return new ApiResult<>(-1, "您已达到最大中奖数", null);
        }

        // lua脚本实现原子操作（取token+判断是否中奖+返回token/token放回redis并返回未抽中标识）
        final Long token = luaScript.tokenCheck(RedisKeys.GAME_TOKENS + gameId, Long.toString(now.getTime()));
        if (token == 0) {
            return new ApiResult<>(-1, "奖品已抽光", null);
        } else if (token == 1) {
            return new ApiResult<>(0, "未中奖", null);
        }

        // 中奖了
        final CardProduct product = (CardProduct) redisUtil.get(RedisKeys.GAME_TOKEN + gameId + "_" + token);

        redisUtil.incr(RedisKeys.USER_HIT + gameId + "_" + userId, 1);
        final CardUserHit userHit = new CardUserHit();
        userHit.setGameid(gameId);
        userHit.setUserid(userId);
        userHit.setHittime(now);
        userHit.setProductid(product.getId());
        userHit.setUserid(userId);
        rabbitTemplate.convertAndSend(RabbitKeys.EXCHANGE_DIRECT, RabbitKeys.QUEUE_HIT, userHit);

        // 返回给前台中奖信息
        return new ApiResult<>(1, "恭喜中奖", product);
    }

    @GetMapping("/info/{gameId}")
    @ApiOperation(value = "缓存信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "gameId", value = "活动id", example = "1", required = true)
    })
    public ApiResult<Map<String, Object>> info(@PathVariable final int gameId) {
        final Map<String, Object> map = new LinkedHashMap<>();
        map.put(RedisKeys.GAME_INFO + gameId, redisUtil.get(RedisKeys.GAME_INFO + gameId));
        final List<Object> tokens = redisUtil.lrange(RedisKeys.GAME_TOKENS + gameId, 0, -1);
        final Map<String, Object> tokenMap = new LinkedHashMap<>();
        if (tokens == null) {
            return new ApiResult<>(-1, "", null);
        }
        tokens.forEach(t -> tokenMap.put(
                new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date(Long.parseLong(t.toString()) / 1000))
                , redisUtil.get(RedisKeys.GAME_TOKEN + gameId + "_" + t)
        ));

        map.put(RedisKeys.GAME_TOKENS + gameId, tokenMap);
        map.put(RedisKeys.GAME_MAX_GOAL + gameId, redisUtil.hmget(RedisKeys.GAME_MAX_GOAL + gameId));
        map.put(RedisKeys.GAME_MAX_ENTER + gameId, redisUtil.hmget(RedisKeys.GAME_MAX_ENTER + gameId));
        return new ApiResult<>(200, "缓存信息", map);
    }
}
