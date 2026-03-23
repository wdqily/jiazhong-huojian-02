package com.jiazhong.huojian.mybatis.m5;


import com.jiazhong.huojian.mybatis.m5.Mapper.EmpMapper;
import com.jiazhong.huojian.mybatis.m5.bean.Emp;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class App {
    //一级缓存
    private static void a1() {
        InputStream in = App.class.getClassLoader().getResourceAsStream("config.xml");
        SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(in);
        SqlSession session1 = ssf.openSession();
        EmpMapper mapper = session1.getMapper(EmpMapper.class);
        Emp emp1 = mapper.findEmpById(7788);
        System.out.println(emp1);
        //不从数据库中查，不需要连接数据库，直接查询
        Emp emp2 = mapper.findEmpById(7788);
        System.out.println(emp2);
        session1.close();

    }

    private static void a2() {
        InputStream in = App.class.getClassLoader().getResourceAsStream("config.xml");
        SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(in);
        SqlSession session1 = ssf.openSession();
        EmpMapper mapper = session1.getMapper(EmpMapper.class);
        Emp emp1 = mapper.findEmpById(7788);
        System.out.println(emp1);
        //查询数据不一致，需要重新查询
        Emp emp2 = mapper.findEmpById(7789);
        System.out.println(emp2);
        session1.close();

    }

    private static void a3() {
        InputStream in = App.class.getClassLoader().getResourceAsStream("config.xml");
        SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(in);
        SqlSession session1 = ssf.openSession();
        EmpMapper mapper1 = session1.getMapper(EmpMapper.class);
        Emp emp1 = mapper1.findEmpById(7788);
        System.out.println(emp1);
        //不需要连接数据库 直接查询
        EmpMapper mapper2 = session1.getMapper(EmpMapper.class);
        Emp emp2 = mapper2.findEmpById(7788);
        System.out.println(emp2);
        session1.close();

    }

    private static void a4() {
        InputStream in = App.class.getClassLoader().getResourceAsStream("config.xml");
        SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(in);
        SqlSession session1 = ssf.openSession();
        SqlSession session2 = ssf.openSession();
        EmpMapper mapper1 = session1.getMapper(EmpMapper.class);
        Emp emp1 = mapper1.findEmpById(7788);
        System.out.println(emp1);
        session1.close();
        //两次查询 session不同 结论：一级缓存的生命周期为session
        EmpMapper mapper2 = session2.getMapper(EmpMapper.class);
        Emp emp2 = mapper2.findEmpById(7788);
        System.out.println(emp2);
        session2.close();
    }

    //缓存失效
    private static void b1() {
        InputStream in = App.class.getClassLoader().getResourceAsStream("config.xml");
        SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(in);
        SqlSession session = ssf.openSession();
        EmpMapper mapper1 = session.getMapper(EmpMapper.class);
        Emp emp1 = mapper1.findEmpById(7788);
        System.out.println(emp1);
        session.clearCache();//清除缓存 session.close()
        EmpMapper mapper2 = session.getMapper(EmpMapper.class);
        Emp emp2 = mapper2.findEmpById(7788);
        System.out.println(emp2);
        session.close();
    }

    private static void b2() {
        InputStream in = App.class.getClassLoader().getResourceAsStream("config.xml");
        SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(in);
        SqlSession session = ssf.openSession();
        EmpMapper mapper1 = session.getMapper(EmpMapper.class);
        Emp emp1 = mapper1.findEmpById(7788);
        System.out.println(emp1);
        //进行更新操作时(delete，insert以及update)，不管是否成功，都会清空缓存，需要重新查询
        int row = mapper1.deleteEmpById(99999);
        System.out.println(row);
        EmpMapper mapper2 = session.getMapper(EmpMapper.class);
        Emp emp2 = mapper2.findEmpById(7788);
        System.out.println(emp2);
        session.close();
    }

    //二级缓存
    private static void c() {
        InputStream in = App.class.getClassLoader().getResourceAsStream("config.xml");
        SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(in);
        SqlSession session1 = ssf.openSession();
        SqlSession session2 = ssf.openSession();
        EmpMapper mapper1 = session1.getMapper(EmpMapper.class);
        Emp emp1 = mapper1.findEmpById(7788);
        System.out.println(emp1);
        session1.close();
        EmpMapper mapper2 = session2.getMapper(EmpMapper.class);
        Emp emp2 = mapper2.findEmpById(7788);
        System.out.println(emp2);
        session2.close();
    }

    public static void main(String[] args) {
        c();
    }
}