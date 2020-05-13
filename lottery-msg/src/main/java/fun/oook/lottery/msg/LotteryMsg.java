package fun.oook.lottery.msg;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author ZhouYu
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker
@EnableTransactionManagement
@EnableScheduling
@MapperScan("fun.oook.lottery.commons.db.mapper")
public class LotteryMsg {

    public static void main(String[] args) {
        SpringApplication.run(LotteryMsg.class, args);
    }

}
