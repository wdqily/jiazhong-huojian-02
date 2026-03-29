package com.jiazhong.huojian.spring.boot.example.crud.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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

    @Override
    public PageInfo<Emp> findByPage(int page) {
        PageHelper.startPage(page, 10);
        List<Emp> list = empMapper.findAll();
        return new PageInfo<>(list);
    }

    @Override
    public PageInfo<Emp> searchByName(int page, String ename) {
        PageHelper.startPage(page, 10);
        List<Emp> list = empMapper.searchByName("%" + ename + "%");
        return new PageInfo<>(list);
    }

    @Override
    public int delete(int id) {
        return empMapper.delete(id);
    }
}
