package fun.oook.lottery.commons.config;

/**
 * @author ZhouYu
 * @since 0.0.1
 */
public class RabbitKeys {
    /**
     * 中奖队列名称
     */
    public static final String QUEUE_HIT = "lottery_queue_hit";

    /**
     * 参与活动队列
     */
    public static final String QUEUE_PLAY = "lottery_queue_play";

    /**
     * 中奖路由名称
     */
    public static final String EXCHANGE_DIRECT = "lottery_exchange_direct";
}
