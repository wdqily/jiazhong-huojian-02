package com.jiazhong.huojian.spring.boot.rocketmq.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Users implements Serializable {
    private String name;
    private Integer age;
    private Character gender;
    private Integer id;
}
