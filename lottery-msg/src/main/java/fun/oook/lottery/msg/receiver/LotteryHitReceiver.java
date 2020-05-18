package fun.oook.lottery.msg.receiver;

import fun.oook.lottery.commons.config.RabbitKeys;
import fun.oook.lottery.commons.db.entity.CardUserHit;
import fun.oook.lottery.commons.db.mapper.CardUserHitMapper;
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
@RabbitListener(queues = RabbitKeys.QUEUE_HIT)
public class LotteryHitReceiver {

    private static final Logger log = LoggerFactory.getLogger(LotteryHitReceiver.class);

    @Resource
    private CardUserHitMapper userHitMapper;

    @RabbitHandler
    public void processMessage(final CardUserHit message) {
        log.info("user hit: game={},product={},time={}", message.getGameid(), message.getProductid(), message.getHittime());

        userHitMapper.insert(message);
    }
}
