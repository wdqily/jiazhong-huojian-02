package com.jiazhong.huojian.spring.boot.example.crud.mapper;

import com.jiazhong.huojian.spring.boot.example.crud.bean.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface EmpMapper {
    @Select("SELECT * FROM emp WHERE state=1")
    List<Emp> findAll();
}
