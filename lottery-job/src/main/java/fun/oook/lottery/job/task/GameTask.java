package fun.oook.lottery.job.task;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import fun.oook.lottery.commons.db.entity.CardGame;
import fun.oook.lottery.commons.db.entity.CardGameExample;
import fun.oook.lottery.commons.db.mapper.CardGameMapper;
import fun.oook.lottery.commons.db.mapper.CardGameProductMapper;
import fun.oook.lottery.commons.db.mapper.CardGameRulesMapper;
import fun.oook.lottery.job.annotation.SimpleElasticJob;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

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


    @Override
    public void execute(final ShardingContext shardingContext) {
        final Date now = new Date();

        final CardGameExample gameExample = new CardGameExample();
        gameExample.createCriteria()
                .andStarttimeGreaterThan(now)
                .andStarttimeLessThanOrEqualTo(DateUtils.addMinutes(now, 1));

        final List<CardGame> gameList = gameMapper.selectByExample(gameExample);
        log.info("game list scan: size = {}", gameList.size());
        if (CollectionUtils.isEmpty(gameList)) {
            return;
        }
        gameList.forEach(game -> {
            final long start = game.getStarttime().getTime();
            final long end = game.getEndtime().getTime();
            final long expire = (end - now.getTime()) / 1000;
            final long duration = end - start;

            game.setStatus(1);


        });

    }
}
