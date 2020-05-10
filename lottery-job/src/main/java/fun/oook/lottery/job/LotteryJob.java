package fun.oook.lottery.job;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("fun.oook.lottery.commons.db.mapper")
public class LotteryJob {

    public static void main(String[] args) {
        SpringApplication.run(LotteryJob.class, args);
    }

}
