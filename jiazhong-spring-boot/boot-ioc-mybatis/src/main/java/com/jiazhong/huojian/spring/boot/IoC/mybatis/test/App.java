package com.jiazhong.huojian.spring.boot.IoC.mybatis.test;

import com.jiazhong.huojian.spring.boot.IoC.mybatis.bean.Emp;
import com.jiazhong.huojian.spring.boot.IoC.mybatis.mapper.EmpMapper;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@Slf4j
@SpringBootTest//这是一个测试类
public class App {
    @Resource
    private EmpMapper empMapper;

    @Test
    public void a() {
        List<Emp> list = empMapper.findAll();
        list.forEach(System.out::println);
    }

    @Test
    public void b() {
        Emp emp = empMapper.findEmpById(8005);
        log.info("emp:{}", emp);

    }

    @Test
    public void c() {
        Emp emp = new Emp();
        emp.setEname("王家乐");
        emp.setEmpNo(8001);
        emp.setComm(8888);
        emp.setJob("歌手");
        emp.setSal(77777);
        empMapper.updateEmp(emp);
    }

    @Test
    public void d() {
        int row = empMapper.deleteEmp(8005);
        log.info("row:{}", row);
    }

    @Test
    public void e() {
        Emp emp = new Emp();
        emp.setJob("程序猿");
        emp.setEname("niu");
        emp.setComm(9999);
        emp.setDeptNo(44);
        emp.setMgr(6666);
        empMapper.addEmp(emp);
    }

}
