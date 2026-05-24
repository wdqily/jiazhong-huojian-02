package com.jiazhong.huojian.spring.boot.example.shopping.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class Goods implements Serializable {
    private String id;
    private String goodsName;
    private Double price;
    private String createTime;
    private Integer state;

}
