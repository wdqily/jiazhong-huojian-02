package com.jiazhong.huojian.mybatis.m5.been;

import lombok.Data;

import java.io.Serializable;

@Data
public class Emp implements Serializable {
    private Integer empNo;
    private String ename;
    private String job;
    private Integer mgr;
    private String hireDate;
    private Integer sal;
    private Integer comm;
    private Integer deptNo;
}
