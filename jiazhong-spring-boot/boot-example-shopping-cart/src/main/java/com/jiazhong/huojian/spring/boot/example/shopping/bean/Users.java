package com.jiazhong.huojian.spring.boot.example.shopping.bean;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

@Data
public class Users implements Serializable {
    @TableId
    private String id;
    private String username;
    private String password;
    private String nickname;
    private Integer state;

}
