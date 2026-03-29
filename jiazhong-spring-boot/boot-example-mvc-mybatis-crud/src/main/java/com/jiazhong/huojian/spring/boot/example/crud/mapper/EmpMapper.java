package com.jiazhong.huojian.spring.boot.example.crud.mapper;

import com.jiazhong.huojian.spring.boot.example.crud.bean.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface EmpMapper {
    @Select("SELECT * FROM emp WHERE state=1")
    List<Emp> findAll();

    @Select("select * from emp where state=1 and ENAME like #{ename}")
    List<Emp> searchByName(String ename);

    @Update("update emp set state=0 where state=1 and EMPNO=#{id}")
    int delete(int id);

}
