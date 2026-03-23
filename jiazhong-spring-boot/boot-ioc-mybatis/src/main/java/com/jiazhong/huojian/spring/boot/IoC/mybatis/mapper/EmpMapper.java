package com.jiazhong.huojian.spring.boot.IoC.mybatis.mapper;

import com.jiazhong.huojian.spring.boot.IoC.mybatis.bean.Emp;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper// 产生EmpMapper接口的代理对象
public interface EmpMapper {
    @Select("select * from emp")
    List<Emp> findAll();

    @Select("select * from emp where EMPNO=#{id}")
    Emp findEmpById(int id);

    @Update("update emp set  ENAME=#{ename},JOB=#{job},MGR=#{mgr},SAL=#{sal},COMM=#{comm},DEPTNO=#{deptNo} where empno=#{empNo}")
    int updateEmp(Emp emp);

    // 逻辑删除 state status is_deleted
    @Update("update emp set state=0 where EMPNO=#{id} and state=1")
    int deleteEmp(int id);

    @Insert("insert into emp values(null,#{ename},#{job},#{mgr},now(),#{sal},#{comm},#{deptNo},1)")
    int addEmp(Emp emp);

}
