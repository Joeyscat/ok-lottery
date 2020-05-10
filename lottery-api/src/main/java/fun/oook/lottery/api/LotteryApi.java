package fun.oook.lottery.api;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker
@EnableTransactionManagement
@MapperScan("fun.oook.lottery.commons.db.mapper")
@EnableCaching
public class LotteryApi {

    public static void main(String[] args) {
        SpringApplication.run(LotteryApi.class, args);
    }

}
