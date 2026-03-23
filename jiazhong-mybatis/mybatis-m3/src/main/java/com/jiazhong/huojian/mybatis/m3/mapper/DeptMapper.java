package com.jiazhong.huojian.mybatis.m3.mapper;

import com.jiazhong.huojian.mybatis.m3.bean.Dept;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface DeptMapper {
    @Select("select * from dept where deptno=#{deptNo}")
    Dept findDeptById(int deptNo);

    @Select("select * from dept where deptno=#{deptNo}")
    @Results(value = {
            @Result(column = "deptno", property = "deptNo", id = true),
            @Result(column = "dname", property = "dName"),
            @Result(column = "deptNo", property = "emps",
                    many = @Many(select = "com.jiazhong.huojian.mybatis.m3.mapper.EmpMapper.findEmpByDeptNo"))
    }
    )
    Dept findDeptById2(int deptNo);
}
