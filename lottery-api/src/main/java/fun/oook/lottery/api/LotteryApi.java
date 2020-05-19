package fun.oook.lottery.api;

import com.github.pagehelper.PageHelper;
import fun.oook.lottery.api.controller.LoginController;
import fun.oook.lottery.api.coonfig.SwaggerConfig;
import fun.oook.lottery.api.service.CardGameService;
import fun.oook.lottery.commons.config.RedisConfig;
import fun.oook.lottery.commons.util.RedisUtil;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Properties;

@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker
@EnableTransactionManagement
@MapperScan("fun.oook.lottery.commons.db.mapper")
@EnableCaching
@ComponentScan(basePackageClasses = {RedisUtil.class, SwaggerConfig.class, LoginController.class, CardGameService.class, RedisConfig.class})
public class LotteryApi {

    public static void main(String[] args) {
        SpringApplication.run(LotteryApi.class, args);
    }


    @Bean
    public PageHelper pageHelper() {
        final PageHelper pageHelper = new PageHelper();
        final Properties properties = new Properties();

        properties.setProperty("offsetAsPageNum", "true");
        properties.setProperty("rowBoundsWithCount", "true");
        properties.setProperty("reasonable", "true");
        properties.setProperty("dialect", "mysql");

        pageHelper.setProperties(properties);
        return pageHelper;
    }
}
