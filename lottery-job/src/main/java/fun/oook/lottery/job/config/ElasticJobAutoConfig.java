package fun.oook.lottery.job.config;

import com.dangdang.ddframe.job.api.simple.SimpleJob;
import com.dangdang.ddframe.job.config.JobCoreConfiguration;
import com.dangdang.ddframe.job.config.simple.SimpleJobConfiguration;
import com.dangdang.ddframe.job.event.rdb.JobEventRdbConfiguration;
import com.dangdang.ddframe.job.lite.api.listener.ElasticJobListener;
import com.dangdang.ddframe.job.lite.config.LiteJobConfiguration;
import com.dangdang.ddframe.job.lite.spring.api.SpringJobScheduler;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperConfiguration;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperRegistryCenter;
import fun.oook.lottery.job.annotation.SimpleElasticJob;
import fun.oook.lottery.job.listener.SimpleElasticJobListener;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.Map;

/**
 * @author ZhouYu
 * @since 0.0.1
 */
@Configuration
public class ElasticJobAutoConfig {

    @Value("${spring.cloud.zookeeper.connect-string}")
    private String serverList;

    @Value("${spring.application.name}")
    private String namespace;

    @Value("${elasticjob.zookeeper.session-timeout-milliseconds}")
    private int sessionTimeoutMilliseconds;

    @Resource
    private ApplicationContext applicationContext;

    @PostConstruct
    public void initElasticJob() {
        final ZookeeperConfiguration config = new ZookeeperConfiguration(serverList, namespace);
        config.setSessionTimeoutMilliseconds(sessionTimeoutMilliseconds);
        final ZookeeperRegistryCenter registryCenter = new ZookeeperRegistryCenter(config);
        registryCenter.init();

        final Map<String, SimpleJob> simpleJobMap = applicationContext.getBeansOfType(SimpleJob.class);
        for (final Map.Entry<String, SimpleJob> entry : simpleJobMap.entrySet()) {
            final SimpleJob simpleJob = entry.getValue();
            final SimpleElasticJob simpleElasticJobAnnotation = simpleJob.getClass().getAnnotation(SimpleElasticJob.class);

            final String cron = StringUtils.defaultIfBlank(simpleElasticJobAnnotation.cron(), simpleElasticJobAnnotation.value());
            final SimpleJobConfiguration simpleJobConfiguration = new SimpleJobConfiguration(JobCoreConfiguration.newBuilder(simpleJob.getClass().getName(), cron, simpleElasticJobAnnotation.shardingTotalCount())
                    .shardingItemParameters(simpleElasticJobAnnotation.shardingItemParameters()).build(),
                    simpleJob.getClass().getCanonicalName());
            final LiteJobConfiguration liteJobConfiguration = LiteJobConfiguration.newBuilder(simpleJobConfiguration).overwrite(true).build();

            final String dataSourceRef = simpleElasticJobAnnotation.dataSource();
            if (StringUtils.isNotBlank(dataSourceRef)) {
                if (!applicationContext.containsBean(dataSourceRef)) {
                    throw new RuntimeException("not exist datasource [" + dataSourceRef + "]");
                }

                final DataSource dataSource = (DataSource) applicationContext.getBean(dataSourceRef);
                final JobEventRdbConfiguration jobEventRdbConfiguration = new JobEventRdbConfiguration(dataSource);
                final SpringJobScheduler jobScheduler = new SpringJobScheduler(simpleJob, registryCenter, liteJobConfiguration, jobEventRdbConfiguration);
                jobScheduler.init();
            } else {
                final SpringJobScheduler jobScheduler = new SpringJobScheduler(simpleJob, registryCenter, liteJobConfiguration);
                jobScheduler.init();
            }
        }
    }

    @Bean
    public ElasticJobListener elasticJobListener() {
        return new SimpleElasticJobListener(100, 100);
    }
}
