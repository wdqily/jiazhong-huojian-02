package com.jiazhong.huojian.spring.boot.example.shopping.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("`order`")
public class Order implements Serializable {
    @TableId
    private String id;
    private String userId;
    private String createTime;
    private Integer state;
    @TableField(exist = false)
    private String nickname;
    @TableField(exist = false)
    private String address;
    @TableField(exist = false)
    private String phone;
}
