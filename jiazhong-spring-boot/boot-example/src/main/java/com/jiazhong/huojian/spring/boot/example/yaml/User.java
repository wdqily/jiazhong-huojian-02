package com.jiazhong.huojian.spring.boot.example.yaml;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Data
@Component
@PropertySource(value = "classpath:user.properties", encoding = "utf-8")
@ConfigurationProperties(prefix = "user")
public class User {
    private Integer id;
    private String name1;
    private String[] loves;
    private Character gender;
}
