package com.jiazhong.huojian.spring.boot.mybatis.plus.been;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;

@Data
public class Emp implements Serializable {
    //这个属性是数据库的主键
    @TableId(value = "empno", type = IdType.ASSIGN_ID)//雪花算法
    private Integer empNo;
    private String ename;
    private String job;
    private Integer mgr;
    //自动填充:当添加或者修改时自动填充默认值
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String hireDate;
    private Integer sal;
    private Integer comm;
    private Integer deptNo;
    //局部逻辑删除写法
    @TableLogic(delval = "0", value = "1")
    private Integer state;
    @TableField(exist = false)//数据库中不存在的字段
    private Integer number;
}
