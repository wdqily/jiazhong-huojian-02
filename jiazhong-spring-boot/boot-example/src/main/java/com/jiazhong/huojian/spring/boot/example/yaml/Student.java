package com.jiazhong.huojian.spring.boot.example.yaml;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class Student {
    private Integer id;
    private String name;
}
