package fun.oook.lottery.job.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author ZhouYu
 * @since 0.0.1
 */
@Configuration
public class DataSourceConfig {

    @Bean("datasource")
    @ConfigurationProperties("spring.datasource")
    public DataSource dataSource() {
        return DruidDataSourceBuilder.create().build();
    }
}
