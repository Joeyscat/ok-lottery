package fun.oook.lottery.msg.receiver;

import fun.oook.lottery.commons.config.RabbitKeys;
import fun.oook.lottery.commons.db.entity.CardUserGame;
import fun.oook.lottery.commons.db.mapper.CardUserGameMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author ZhouYu
 * @since 0.0.1
 */
@Component
@RabbitListener(queues = RabbitKeys.QUEUE_PLAY)
public class LotteryPlayReceiver {

    private static final Logger log = LoggerFactory.getLogger(LotteryPlayReceiver.class);

    @Resource
    private CardUserGameMapper userGameMapper;

    @RabbitHandler
    public void processMessage(final CardUserGame message) {
        log.info("user play: game={},user={},time={}", message.getGameId(), message.getUserId(), message.getCreatedTime());

        userGameMapper.insert(message);
    }
}
