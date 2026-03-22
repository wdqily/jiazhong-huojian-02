package com.jiazhong.huojian.spring.boot.IoC.mybatis.bean;

import lombok.Data;

@Data
public class Emp {
    private Integer empNo;
    private String ename;
    private String job;
    private Integer mgr;
    private String hireDate;
    private Integer sal;
    private Integer comm;
    private Integer deptNo;
}
