package com.jiazhong.huojian.spring.boot.example.shopping.bean;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

@Data
public class Stock implements Serializable {
    @TableId
    private String id;
    private String goodsId;
    private Integer number;
}
