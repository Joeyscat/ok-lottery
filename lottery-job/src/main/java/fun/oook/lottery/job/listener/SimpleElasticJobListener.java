package fun.oook.lottery.job.listener;

import com.dangdang.ddframe.job.executor.ShardingContexts;
import com.dangdang.ddframe.job.lite.api.listener.AbstractDistributeOnceElasticJobListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author ZhouYu
 * @since 0.0.1
 */
public class SimpleElasticJobListener extends AbstractDistributeOnceElasticJobListener {

    private final Logger log = LoggerFactory.getLogger(SimpleElasticJobListener.class);

    public SimpleElasticJobListener(final long startedTimeoutMilliseconds, final long completedTimeoutMilliseconds) {
        super(startedTimeoutMilliseconds, completedTimeoutMilliseconds);
    }

    @Override
    public void doBeforeJobExecutedAtLastStarted(final ShardingContexts shardingContexts) {
        log.info("任务开始");
    }

    @Override
    public void doAfterJobExecutedAtLastCompleted(final ShardingContexts shardingContexts) {
        log.info("任务结束");
    }
}
