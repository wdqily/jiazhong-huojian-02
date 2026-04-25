package com.jiazhong.huojian.spring.boot.mybatis.plus.test;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jiazhong.huojian.spring.boot.mybatis.plus.been.Emp;
import com.jiazhong.huojian.spring.boot.mybatis.plus.service.EmpService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class App {
    @Resource
    private EmpService service;

    //全查询
    @Test
    public void findAll() {
        service.list().forEach(System.out::println);
    }

    //添加
    @Test
    public void save() {
        Emp emp = new Emp();
        emp.setEname("里三三");
        emp.setJob("算法工程师");
        emp.setComm(8888);
        emp.setSal(9999);
        service.save(emp);
    }

    //修改
    @Test
    public void update() {
        Emp emp = new Emp();
        emp.setEname("李思思");
        emp.setEmpNo(-2103013375);
        service.updateById(emp);
    }

    @Test
    //物理删除
    public void delete1() {
        service.removeById(8120);
    }

    @Test
    //逻辑删除
    public void delete2() {
        service.removeById(8118);
    }

    @Test
    //按ID查
    public void findByID() {
        Emp emp = service.getById(8117);
        log.info("emp:{}", emp);
    }

    //分页操作
    @Test
    public void page() {
        Page<Emp> page = Page.of(1, 10);
        service.list(page).forEach(System.out::println);
        page.setRecords(service.list(page));
        log.info("当前页数据：{}", page);
    }
}

