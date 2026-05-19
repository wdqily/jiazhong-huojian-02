package com.jiazhong.huojian.spring.boot.redis.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

import java.io.Serializable;

@Data
public class Emp implements Serializable {
    @TableId
    private Integer empNo;
    private String ename;
    private String job;
    private Integer mgr;
    private String hireDate;
    private Integer sal;
    private Integer comm;
    @TableField(value = "deptno")
    private Integer deptNo;
    @TableLogic(delval = "0", value = "1")
    private Integer state;
}
