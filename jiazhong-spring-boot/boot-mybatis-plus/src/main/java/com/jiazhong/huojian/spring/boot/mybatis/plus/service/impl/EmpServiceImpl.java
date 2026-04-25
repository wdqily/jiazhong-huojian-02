package com.jiazhong.huojian.spring.boot.mybatis.plus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jiazhong.huojian.spring.boot.mybatis.plus.been.Emp;
import com.jiazhong.huojian.spring.boot.mybatis.plus.mapper.EmpMapper;
import com.jiazhong.huojian.spring.boot.mybatis.plus.service.EmpService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpServiceImpl extends ServiceImpl<EmpMapper, Emp> implements EmpService {
    @Resource
    private EmpMapper empMapper;

    @Override
    public List<Emp> findAllEmp() {
        return empMapper.findAllEmp();
    }
}
