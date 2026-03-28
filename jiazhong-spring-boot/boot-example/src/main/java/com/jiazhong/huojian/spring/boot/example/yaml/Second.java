package com.jiazhong.huojian.spring.boot.example.yaml;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "obj2")
public class Second {
    private Integer id;
    private String name;
    private Character gender;
}
