package com.jiazhong.huojian.mybatis.m2;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jiazhong.huojian.mybatis.m2.been.Emp;
import com.jiazhong.huojian.mybatis.m2.mapper.EmpMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

public class App {
    private static void a() {
        InputStream inputStream = Emp.class.getClassLoader().getResourceAsStream("config.xml");
        SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sessions = ssf.openSession();
        EmpMapper mapper = sessions.getMapper(EmpMapper.class);
        //全查询
        List<Emp> list = mapper.findAll();
        list.forEach(System.out::println);
        //添加
        Emp emp = new Emp();
        emp.setEname("lisi");
//        emp.setJob("演员");
        emp.setMgr(8888);
        emp.setHireDate("2026-3-14");
        emp.setSal(6666);
        emp.setComm(888);
        emp.setDeptNo(002);
        emp.setEmpNo(7946);
//        mapper.saveEmp(emp);
        //更新
//        mapper.updateEmp(emp);
        //删除
        mapper.deleteEmp(7946);
        sessions.commit();
        sessions.close();
    }

    private static void b1() {
        InputStream inputStream = Emp.class.getClassLoader().getResourceAsStream("config.xml");
        SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sessions = ssf.openSession();
        EmpMapper mapper = sessions.getMapper(EmpMapper.class);
//        mapper.findEmpById3(7688);
        List<Emp> emp = mapper.findEmpByEname1("%王%");
        System.out.println(emp);
        sessions.commit();
        sessions.close();
    }

    private static void b2() {
        InputStream inputStream = Emp.class.getClassLoader().getResourceAsStream("config.xml");
        SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sessions = ssf.openSession();
        EmpMapper mapper = sessions.getMapper(EmpMapper.class);
//        Emp emp = new Emp();
//        emp.setEname("%张%");
//        emp.setJob("程序员");
//        List<Emp> list = mapper.findEmp1(emp);
//        Map map = new HashMap();
//        map.put("job","程序员");
//        map.put("ename","%张%");
//        List<Emp> list = mapper.findEmp2(map);
        List<Emp> list = mapper.findEmp3("程序员", "%张%");
        System.out.println(list);
        sessions.commit();
        sessions.close();
    }

    private static void c1() {
        InputStream inputStream = Emp.class.getClassLoader().getResourceAsStream("config.xml");
        SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sessions = ssf.openSession();
        EmpMapper mapper = sessions.getMapper(EmpMapper.class);
        int page = 1;
        int size = 10;
        List<Emp> list = mapper.findPage((page - 1) * size, size);
        System.out.println(list);
        sessions.commit();
        sessions.close();
    }

    private static void c2() {
        InputStream inputStream = Emp.class.getClassLoader().getResourceAsStream("config.xml");
        SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sessions = ssf.openSession();
        EmpMapper mapper = sessions.getMapper(EmpMapper.class);
        PageHelper.startPage(5, 10);
        List<Emp> list = mapper.findAll();
        PageInfo<Emp> pageInfo = new PageInfo<>(list);
        System.out.println(pageInfo);
        sessions.commit();
        sessions.close();
    }

    private static void d1() {
        InputStream inputStream = Emp.class.getClassLoader().getResourceAsStream("config.xml");
        SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sessions = ssf.openSession();
        EmpMapper mapper = sessions.getMapper(EmpMapper.class);
        Emp emp = mapper.find1(8001);
        System.out.println(emp);
        sessions.commit();
        sessions.close();
    }

    private static void d2() {
        InputStream inputStream = Emp.class.getClassLoader().getResourceAsStream("config.xml");
        SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sessions = ssf.openSession();
        EmpMapper mapper = sessions.getMapper(EmpMapper.class);
        Emp emp = mapper.find2(8001);
        System.out.println(emp);
        sessions.commit();
        sessions.close();
    }

    public static void main(String[] args) {
        d2();
    }
}