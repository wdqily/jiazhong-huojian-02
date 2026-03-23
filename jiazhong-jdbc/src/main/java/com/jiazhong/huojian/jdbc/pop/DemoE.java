package com.jiazhong.huojian.jdbc.pop;

import com.jiazhong.huojian.jdbc.bean.Emp;
import com.jiazhong.huojian.jdbc.oop.db.DBManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DemoE {
    private static Emp findEmpByEmpNo(int empNO) throws ClassNotFoundException, SQLException {
//        Class.forName("com.mysql.cj.jdbc.Driver");
//        String username  = "root";
//        String password ="20050217";
//        String url = "jdbc:mysql://localhost:3306/jiazhong_2026_1?serverTimezone=Asia/Shanghai&useSSL=false&allowPublicKeyRetrieval=true";
//        Connection conn = DriverManager.getConnection(url,username,password);
        Connection conn = DBManager.getConnection();
        String sql = "select* from emp where empno=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, empNO);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            int no = rs.getInt(1);
            String ename = rs.getString(2);
            String job = rs.getString(3);
            int mgr = rs.getInt(4);
            String hireDate = rs.getString(5);
            int sal = rs.getInt(6);
            int comm = rs.getInt(7);
            int deptNo = rs.getInt(8);
            DBManager.close(conn, ps, rs);//单条可以在循环里
            return new Emp(no, ename, job, mgr, hireDate, sal, comm, deptNo);
        }
        return null;
    }

    //全表查询
    private static List<Emp> findAll() throws ClassNotFoundException, SQLException {
        List<Emp> list = new ArrayList<>();
        Class.forName("com.mysql.cj.jdbc.Driver");
//        String username  = "root";
//        String password ="20050217";
//        String url = "jdbc:mysql://localhost:3306/jiazhong_2026_1?serverTimezone=Asia/Shanghai&useSSL=false&allowPublicKeyRetrieval=true";
//        Connection conn = DriverManager.getConnection(url,username,password);
        Connection conn = DBManager.getConnection();
        String sql = "select* from emp ";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            int no = rs.getInt(1);
            String ename = rs.getString(2);
            String job = rs.getString(3);
            int mgr = rs.getInt(4);
            String hireDate = rs.getString(5);
            int sal = rs.getInt(6);
            int comm = rs.getInt(7);
            int deptNo = rs.getInt(8);
            Emp emp = new Emp(no, ename, job, mgr, hireDate, sal, comm, deptNo);
            list.add(emp);
        }
        DBManager.close(conn, ps, rs);//循环外关闭
        return list;
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Emp emp = findEmpByEmpNo(8040);
        System.out.println(emp);
        List<Emp> all = findAll();
        all.forEach(System.out::println);
    }
}
