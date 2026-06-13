package com.jiazhong.huojian.spring.boot.swagger.config;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(info = @Info(
        title = "我是注解版本的swagger3",
        description = "这个是我第一个注解版本的文档描述",
        version = "1.0.1",
        contact = @Contact(
                name = "张三",
                email = "zhangsan@qq.com"
        ),
        termsOfService = "https://www.baidu.com",
        license = @License(
                name = "lisi"
        )
))
@Configuration
public class SwaggerConfig {
    /*@Bean
    public OpenAPI springOpenAPI() {
        return new OpenAPI().info(
                new Info().title("我的swagger3")
                        .description("我第⼀个swagger3案例")
                        .version("1.0.0"));
    }*/
}
