package com.jiazhong.huojian.spring.boot.example.crud.mapper;

import com.jiazhong.huojian.spring.boot.example.crud.bean.Emp;
import org.apache.ibatis.annotations.Insert;
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

    @Insert("insert into emp  values(null,#{ename},#{job},#{mgr},#{hireDate},#{sal},#{comm},#{deptNo},1)")
    int add(Emp emp);

    @Update("update emp set ENAME=#{ename},MGR=#{mgr},HIREDATE=#{hireDate},SAL=#{sal},COMM=#{comm},DEPTNO=#{deptNo}, job=#{job} where empNo=#{empNo}")
    int update(Emp emp);

}
