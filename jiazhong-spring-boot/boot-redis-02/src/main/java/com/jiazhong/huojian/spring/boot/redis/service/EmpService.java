package com.jiazhong.huojian.spring.boot.redis.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jiazhong.huojian.spring.boot.redis.bean.Emp;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmpService extends IService<Emp> {
    List<Emp> findAll1();

    Emp findById1(int id);

    // 这两个是注解写法
    List<Emp> findAll2();

    Emp findById2(int id);

    String deleteEmpById1(int id);

    String deleteEmpById2(int id);

    String saveEmp(Emp emp);
}
