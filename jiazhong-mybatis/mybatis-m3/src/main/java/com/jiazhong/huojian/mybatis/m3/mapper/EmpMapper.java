package com.jiazhong.huojian.mybatis.m3.mapper;

import com.jiazhong.huojian.mybatis.m3.been.Emp;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface EmpMapper {
    @Select("select * from emp where empno=#{empNo}")
    //进行映射
    @Results(
            value = {
                    //主键
                    @Result(column = "empno", property = "empNo", id = true),
                    //非主键 如果名字一致可以省略
                    @Result(column = "ename", property = "ename"),
                    //关系
                    @Result(column = "deptNo",
                            property = "dept",
                            one = @One(select = "com.jiazhong.huojian.mybatis.m3.mapper.DeptMapper.findDeptById")
                    )
            }
    )
    Emp findEmpById(int empNo);

    @Select("select * from emp where deptno=#{deptNo}")
    List<Emp> findEmpByDeptNo(int deptNo);
}
