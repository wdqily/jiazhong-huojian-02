package com.jiazhong.huojian.spring.boot.mybatis.plus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jiazhong.huojian.spring.boot.mybatis.plus.been.Emp;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmpMapper extends BaseMapper<Emp> {
    List<Emp> findAllEmp();

}
