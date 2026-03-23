package com.jiazhong.huojian.jdbc.work.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private Integer id;
    private String name;
    private String password;
    private String gender;
    private String birthday;
    private String address;
    private Integer phone;
}
