package com.jiazhong.huojian.spring.boot.redis.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jiazhong.huojian.spring.boot.redis.bean.Emp;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmpMapper extends BaseMapper<Emp> {
}
