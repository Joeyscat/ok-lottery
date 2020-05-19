package fun.oook.lottery.job;

import fun.oook.lottery.commons.config.RedisConfig;
import fun.oook.lottery.commons.util.RedisUtil;
import fun.oook.lottery.job.config.ElasticJobAutoConfig;
import fun.oook.lottery.job.task.GameTask;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("fun.oook.lottery.commons.db.mapper")
@ComponentScan(basePackageClasses = {RedisUtil.class, ElasticJobAutoConfig.class, GameTask.class, RedisConfig.class})
public class LotteryJob {

    public static void main(String[] args) {
        SpringApplication.run(LotteryJob.class, args);
    }
//
//    @Bean
//    @LoadBalanced
//    public RestTemplate restTemplate() {
//        return new RestTemplate();
//    }
}
