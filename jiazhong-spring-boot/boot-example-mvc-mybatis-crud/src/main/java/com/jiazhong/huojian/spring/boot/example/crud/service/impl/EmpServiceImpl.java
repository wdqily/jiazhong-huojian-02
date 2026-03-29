package com.jiazhong.huojian.spring.boot.example.crud.service.impl;

import com.jiazhong.huojian.spring.boot.example.crud.bean.Emp;
import com.jiazhong.huojian.spring.boot.example.crud.mapper.EmpMapper;
import com.jiazhong.huojian.spring.boot.example.crud.service.EmpService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {
    @Resource
    private EmpMapper empMapper;

    @Override
    public List<Emp> findALL() {
        return empMapper.findAll();
    }
}
