package com.jiazhong.huojian.spring.boot.example.shopping.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class Users implements Serializable {
    private String id;
    private String username;
    private String password;
    private String nickname;
}
