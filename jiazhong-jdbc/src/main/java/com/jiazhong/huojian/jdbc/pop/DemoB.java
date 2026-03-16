package com.jiazhong.huojian.jdbc.pop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

//添加
public class DemoB {
    private static Scanner scan = new Scanner(System.in);

    private static void a() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String username = "root";
        String password = "20050217";
        String url = "jdbc:mysql://localhost:3306/jiazhong_2026_1?serverTimezone=Asia/Shanghai&useSSL=false&allowPublicKeyRetrieval=true";
        Connection conn = DriverManager.getConnection(url, username, password);
        String sql = "insert into emp values(null,'王大强','歌手',6327,'2026-1-26',88888,888,001)";
        PreparedStatement ps = conn.prepareStatement(sql);
        int row = ps.executeUpdate();
        System.out.println(row);
        ps.close();
        conn.close();
    }

    private static void b() throws Exception {
        System.out.println("请输入姓名： ");
        String name = scan.next();
        System.out.println("请输入工作： ");
        String job = scan.next();
        System.out.println("请输入上司id： ");
        int mgr = scan.nextInt();
        System.out.println("请输入入职时间： ");
        String hiredate = scan.next();
        System.out.println("请输入工资： ");
        String sal = scan.next();
        System.out.println("请输入奖金： ");
        String comm = scan.next();
        System.out.println("请输入部门编号： ");
        int deptno = scan.nextInt();
        Class.forName("com.mysql.cj.jdbc.Driver");
        String username = "root";
        String password = "20050217";
        String url = "jdbc:mysql://localhost:3306/jiazhong_2026_1?serverTimezone=Asia/Shanghai&useSSL=false&allowPublicKeyRetrieval=true";
        Connection conn = DriverManager.getConnection(url, username, password);
        String sql = "insert into emp values(null ,'" + name +
                "', '"
                + job +
                "', "
                + mgr +
                ", '"
                + hiredate +
                "', "
                + sal +
                ", "
                + comm +
                ", "
                + deptno
                +
                ")";
        PreparedStatement ps = conn.prepareStatement(sql);
        int row = ps.executeUpdate();
        System.out.println(row);
        ps.close();
        conn.close();
    }

    private static void c() throws Exception {
        System.out.println("请输入姓名： ");
        String name = scan.next();
        System.out.println("请输入工作： ");
        String job = scan.next();
        System.out.println("请输入上司id： ");
        int mgr = scan.nextInt();
        System.out.println("请输入入职时间： ");
        String hiredate = scan.next();
        System.out.println("请输入工资： ");
        String sal = scan.next();
        System.out.println("请输入奖金： ");
        String comm = scan.next();
        System.out.println("请输入部门编号： ");
        int deptno = scan.nextInt();
        Class.forName("com.mysql.cj.jdbc.Driver");
        String username = "root";
        String passwoord = "20050217";
        String url = "jdbc:mysql://localhost:3306/jiazhong_2026_1?serverTimezone=Asia/Shanghai&useSSL=false&allowPublicKeyRetrieval=true";
        Connection conn = DriverManager.getConnection(url, username, passwoord);
        String sql = "insert into emp value(null,?,?,?,?,?,?,?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        //在ps对象产生之后，在ps对象执行之前给?赋值
        ps.setString(1, name);
        ps.setString(2, job);
        ps.setInt(3, mgr);
        ps.setString(4, hiredate);
        ps.setString(5, sal);
        ps.setString(6, comm);
        ps.setInt(7, deptno);
        int row = ps.executeUpdate();
        System.out.println("row = " + row);
        ps.close();
        conn.close();
    }

    public static void main(String[] args) throws Exception {
        c();
    }
}
