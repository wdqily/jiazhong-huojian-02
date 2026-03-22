package com.jiazhong.huojian.spring.boot.IoC.mybatis.mapper;

import com.jiazhong.huojian.spring.boot.IoC.mybatis.bean.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper// 产生EmpMapper接口的代理对象
public interface EmpMapper {
    @Select("select * from emp")
    List<Emp> findAll();
}
