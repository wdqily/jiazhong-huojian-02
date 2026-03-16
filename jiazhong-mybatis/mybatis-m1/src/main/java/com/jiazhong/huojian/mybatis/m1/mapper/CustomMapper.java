package com.jiazhong.huojian.mybatis.m1.mapper;

import com.jiazhong.huojian.mybatis.m1.been.Custom;

import java.util.List;

public interface CustomMapper {
    List<Custom> findAll();

    void saveCustom(Custom custom);

    void updateCustom(Custom custom);

    void deleteCustom(int id);
}
