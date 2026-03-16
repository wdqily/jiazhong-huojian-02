package com.jiazhong.huojian.mybatis.m4;

import com.jiazhong.huojian.mybatis.m4.Mapper.EmpMapper;
import com.jiazhong.huojian.mybatis.m4.been.Emp;
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
        List<Emp> emps = mapper.find1(null);
        System.out.println(emps);
        sessions.close();

    }

    private static void b() {
        InputStream inputStream = Emp.class.getClassLoader().getResourceAsStream("config.xml");
        SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sessions = ssf.openSession();
        EmpMapper mapper = sessions.getMapper(EmpMapper.class);
        List<Emp> emps = mapper.find2("aa");
        System.out.println(emps);
        sessions.close();

    }

    private static void c() {
        InputStream inputStream = Emp.class.getClassLoader().getResourceAsStream("config.xml");
        SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sessions = ssf.openSession();
        EmpMapper mapper = sessions.getMapper(EmpMapper.class);
        List<Emp> list = mapper.find3(88888.0);
        System.out.println("list = " + list);
        sessions.close();

    }

    private static void d() {
        InputStream inputStream = Emp.class.getClassLoader().getResourceAsStream("config.xml");
        SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sessions = ssf.openSession();
        EmpMapper mapper = sessions.getMapper(EmpMapper.class);
        List<Emp> list = mapper.find4("运维", 30000.0);
        System.out.println("list = " + list);
        sessions.close();

    }

    private static void e() {
        InputStream inputStream = Emp.class.getClassLoader().getResourceAsStream("config.xml");
        SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sessions = ssf.openSession();
        EmpMapper mapper = sessions.getMapper(EmpMapper.class);
        List<String> job = List.of("a", "b", "c");
        mapper.find5(job);
        sessions.close();

    }

    private static void f() {
        InputStream inputStream = Emp.class.getClassLoader().getResourceAsStream("config.xml");
        SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sessions = ssf.openSession();
        EmpMapper mapper = sessions.getMapper(EmpMapper.class);
        Emp emp = new Emp();
        emp.setEname("aaa");
        List<Emp> list = mapper.find6(emp);
        System.out.println(list);
        sessions.close();

    }

    private static void g() {
        InputStream inputStream = Emp.class.getClassLoader().getResourceAsStream("config.xml");
        SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sessions = ssf.openSession();
        EmpMapper mapper = sessions.getMapper(EmpMapper.class);
        Emp emp = new Emp();
        emp.setEmpNo(8001);
        emp.setEname("aaa");
        emp.setJob("555");
        emp.setMgr(888);
        mapper.update(emp);
        sessions.commit();
        sessions.close();

    }

    public static void main(String[] args) {
        g();
    }
}
