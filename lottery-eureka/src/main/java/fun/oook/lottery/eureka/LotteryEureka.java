package fun.oook.lottery.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class LotteryEureka {

    public static void main(String[] args) {
        SpringApplication.run(LotteryEureka.class, args);
    }

}
