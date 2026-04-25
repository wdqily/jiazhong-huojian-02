package com.jiazhong.huojian.spring.boot.mybatis.plus.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jiazhong.huojian.spring.boot.mybatis.plus.been.Emp;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmpService extends IService<Emp> {
    List<Emp> findAllEmp();
}
