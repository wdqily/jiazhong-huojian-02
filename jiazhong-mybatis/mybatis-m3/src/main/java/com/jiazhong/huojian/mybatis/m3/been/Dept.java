package com.jiazhong.huojian.mybatis.m3.been;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class Dept implements Serializable {
    private Integer deptNo;
    private String dName;
    private String loc;
    private List<Emp> emps;

}
