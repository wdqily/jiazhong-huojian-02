package com.jiazhong.huojian.spring.boot.example.shopping.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jiazhong.huojian.spring.boot.example.shopping.bean.Users;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UsersMapper extends BaseMapper<Users> {
}
