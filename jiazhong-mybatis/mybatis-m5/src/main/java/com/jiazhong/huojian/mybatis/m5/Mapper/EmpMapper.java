package com.jiazhong.huojian.mybatis.m5.Mapper;

import com.jiazhong.huojian.mybatis.m5.been.Emp;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

//当前mapper参与二级缓存
@CacheNamespace
public interface EmpMapper {
    @Select("select * from emp where EMPNO=#{id}")
    Emp findEmpById(int id);

    @Delete("delete from emp where EMPNO=#{id}")
    int deleteEmpById(int id);
}
