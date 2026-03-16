package com.jiazhong.huojian.mybatis.m2.mapper;

import com.jiazhong.huojian.mybatis.m2.been.Emp;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface EmpMapper {
    @Select("select * from emp")
    List<Emp> findAll();

    @Insert("insert into emp values(null,#{ename},#{job},#{mgr},#{hireDate},#{sal},#{comm},#{deptNo})")
    void saveEmp(Emp emp);

    @Update("update emp set job=#{job} where empNo=#{empNo} ")
    void updateEmp(Emp emp);

    @Delete("delete from emp where empno=#{empNo}")
    void deleteEmp(int empNo);

    //单个参数问题
    @Select("select * from emp where empno=#{id}")
    Emp findEmpById1(int id);

    @Select("select * from emp where empno=${id}")
    Emp findEmpById2(int id);

    //单个参数上下可以不一致 $是直接填入
    @Select("select * from emp where empno=${asa}")
    Emp findEmpById3(int id);

    @Select("select * from emp where ename like #{ename}")
    List<Emp> findEmpByEname1(String ename);

    @Select("select * from emp where ename like ${ename}")
    List<Emp> findEmpByEname2(String ename);

    //多参数问题
    @Select("select * from emp where job=#{job} and ename=#{ename}")
    List<Emp> findEmp1(Emp emp);

    @Select("select * from emp where job=#{job} and ename=#{ename}")
    List<Emp> findEmp2(Map map);

    @Select("select * from emp where job=#{job} and ename=#{ename}")
    List<Emp> findEmp3(@Param("job") String job, @Param("ename") String ename);

    //分页问题
    @Select("select * from emp limit #{start},#{size}")
    List<Emp> findPage(@Param("start") int start, @Param("size") int size);

    //数据库里列名与对象里的类的属性不一致时
    @Select("select e.*,job as 'job1' from emp e where empno=#{id}")
    Emp find1(int id);

    @Select("select job from emp where empno=#{id}")
    @Results(
            @Result(column = "job", property = "job1")
    )
    Emp find2(int id);
}
