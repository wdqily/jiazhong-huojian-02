package com.jiazhong.huojian.spring.boot.example.shopping.bean;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

@Data
public class Logistics implements Serializable {
    @TableId
    private String id;
    private String nickname;
    private String address;
    private String phone;
    private String orderId;
    private String createTime;
    private Integer state;
}
