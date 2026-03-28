package com.jiazhong.huojian.spring.boot.example.yaml;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class Teacher {
    private String name;
    private Integer age;
}
