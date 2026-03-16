package com.jiazhong.huojian.mybatis.m1.been;

import lombok.Data;

import java.io.Serializable;

@Data
public class Custom implements Serializable {
    private Integer id;
    private String name;
    private String city;
    private String country;
}
