package com.jiazhong.huojian.spring.boot.example.crud.service;

import com.github.pagehelper.PageInfo;
import com.jiazhong.huojian.spring.boot.example.crud.bean.Emp;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmpService {
    List<Emp> findALL();

    PageInfo<Emp> findByPage(int page);

    PageInfo<Emp> searchByName(int page, String ename);

    int delete(int id);

    int add(Emp emp);

    int update(Emp emp);
}
