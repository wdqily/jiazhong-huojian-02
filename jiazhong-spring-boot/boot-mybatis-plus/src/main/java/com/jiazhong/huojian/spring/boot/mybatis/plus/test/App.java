package com.jiazhong.huojian.spring.boot.mybatis.plus.test;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jiazhong.huojian.spring.boot.mybatis.plus.been.Emp;
import com.jiazhong.huojian.spring.boot.mybatis.plus.service.EmpService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

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

    //条件构造器
    @Test
    public void find1() {
        //关系运算符 > < >= <= = !=
        //1.构造条件
        QueryWrapper<Emp> wrapper = new QueryWrapper<>();
        wrapper.eq("job", "程序员");// where job='程序员' ne lt gt le ge
        //2.查询
        List<Emp> list = service.list(wrapper);//查询多条数据
        // Emp emp = service.getOne(wrapper); // 查询一条数据
        list.forEach(System.out::println);

    }

    @Test
    public void find2() {
        //模糊查询
        QueryWrapper<Emp> wrapper = new QueryWrapper<>();
        //wrapper.like("ename","张"); // where ename like '%张%'
        //wrapper.notLike("ename", "张"); // where ename not like '%张%'
        //wrapper.likeLeft("ename","张"); // where ename like '%张'
        wrapper.likeRight("ename", "张");// where ename like '张%'
        service.list(wrapper).forEach(System.out::println);
    }

    @Test
    public void find3() {
        //范围查询
        QueryWrapper<Emp> wrapper = new QueryWrapper<>();
        //wrapper.between("sal", 6000, 9000);
        //wrapper.notBetween("sal",8000,9000);
        wrapper.in("job", "程序员", "歌手");
        wrapper.notIn("job", "程序员", "歌手");
        service.list(wrapper).forEach(System.out::println);
    }

    @Test
    public void find4() {
        //为空查询
        QueryWrapper<Emp> wrapper = new QueryWrapper<>();
        //wrapper.isNull("hiredate"); // where hiredate is null
        wrapper.isNotNull("hiredate");
        service.list(wrapper).forEach(System.out::println);
    }

    @Test
    public void find5() {
        //多条件 and or
        QueryWrapper<Emp> wrapper = new QueryWrapper<>();
        // 如果什么都没写，默认是and
        //wrapper.eq("job", "网页设计");
        //wrapper.le("sal", "7777");
        //如果想要or
        wrapper.eq("job", "程序员")
                .or()
                .le("sal", 9999);
        service.list(wrapper).forEach(System.out::println);
    }

    @Test
    public void find6() {
        // 排序查询
        QueryWrapper<Emp> wrapper = new QueryWrapper<>();
        wrapper.ge("comm", 888);
        //排序
        //wrapper.orderByDesc("sal");
        wrapper.orderByAsc("sal");//升序
        service.list(wrapper).forEach(System.out::println);
    }

    @Test
    public void find7() {
        // 分组查询
        QueryWrapper<Emp> wrapper = new QueryWrapper<>();
        wrapper.groupBy("job");
        wrapper.select("job", "count(0),max(sal),min(sal),sum(sal),avg(sal)");//查询那些列
        service.list(wrapper).forEach(System.out::println);
    }

    @Test
    public void find8() {
        // 分组查询
        QueryWrapper<Emp> wrapper = new QueryWrapper<>();
        //wrapper.last("asasaa");//可以在原有系统的SQL后，追加自己的内容 ❌
        wrapper.last("limit 8");
        service.list(wrapper).forEach(System.out::println);
    }

    @Test
    public void find9() {
        service.findAllEmp();
    }


}

