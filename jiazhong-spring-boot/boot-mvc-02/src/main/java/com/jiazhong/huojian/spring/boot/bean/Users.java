package com.jiazhong.huojian.spring.boot.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Users implements Serializable {
    private Integer id;
    private String username;
    private String password;
    private String nickname;
}
