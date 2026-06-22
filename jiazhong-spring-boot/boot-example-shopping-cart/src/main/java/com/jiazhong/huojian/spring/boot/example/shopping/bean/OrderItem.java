package com.jiazhong.huojian.spring.boot.example.shopping.bean;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class OrderItem {
    @TableId
    private String id;
    private String orderId;
    private String goodsId;
    private Integer number;
    private Double price;
}
