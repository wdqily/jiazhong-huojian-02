package com.jiazhong.huojian.mybatis.m3;


import com.jiazhong.huojian.mybatis.m3.bean.Dept;
import com.jiazhong.huojian.mybatis.m3.bean.Emp;
import com.jiazhong.huojian.mybatis.m3.mapper.DeptMapper;
import com.jiazhong.huojian.mybatis.m3.mapper.EmpMapper;
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
        Emp emp = mapper.findEmpById(8001);
        System.out.println(emp);
        sessions.close();
    }

    private static void b() {
        InputStream inputStream = Emp.class.getClassLoader().getResourceAsStream("config.xml");
        SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sessions = ssf.openSession();
        EmpMapper mapper = sessions.getMapper(EmpMapper.class);
        List<Emp> emps = mapper.findEmpByDeptNo(10);
        System.out.println(emps);
        sessions.close();
    }

    private static void c() {
        InputStream inputStream = Emp.class.getClassLoader().getResourceAsStream("config.xml");
        SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sessions = ssf.openSession();
        DeptMapper mapper = sessions.getMapper(DeptMapper.class);
        Dept dept = mapper.findDeptById2(10);
        System.out.println(dept);
        sessions.close();
    }
    public static void main(String[] args) {
        b();

    }
}
