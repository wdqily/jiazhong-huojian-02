package com.jiazhong.huojian.spring.boot.seckill.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Goods implements Serializable {
    private Integer id;
    private String name;
    private Double price;
}
