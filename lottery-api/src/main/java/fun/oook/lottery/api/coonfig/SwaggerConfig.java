package fun.oook.lottery.api.coonfig;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author ZhouYu
 * @since 0.0.1
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Value("${spring.application.name}")
    private String appName;

    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
                .apis(RequestHandlerSelectors.basePackage("fun.oook.lottery.api.controller"))
                .paths(PathSelectors.any()).build();

    }

    /**
     * 构建api文档的详细信息函数
     *
     * @return info
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("抽奖系统前端" + appName)
                .contact(new Contact("ZhouYu", null, "zhouyu.fun@gmail.com"))
                .version("1.0")
                .description("抽奖系统前端业务接口")
                .build();
    }
}
