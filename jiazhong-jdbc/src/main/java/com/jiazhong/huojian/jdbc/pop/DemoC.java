package com.jiazhong.huojian.jdbc.pop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

//修改
public class DemoC {
    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        System.out.println("请输入姓名： ");
        String name = scan.next();
        System.out.println("请输入工作： ");
        String job = scan.next();
        System.out.println("请输入工资： ");
        String sal = scan.next();
        System.out.println("请输入要修改的编号：");
        int empno = scan.nextInt();
        Class.forName("com.mysql.cj.jdbc.Driver");
        String username = "root";
        String password = "20050217";
        String url = "jdbc:mysql://localhost:3306/jiazhong_2026_1?serverTimezone=Asia/Shanghai&useSSL=false&allowPublicKeyRetrieval=true";
        Connection conn = DriverManager.getConnection(url, username, password);
        String sql = "update emp set ename=?,job=?,sal=?where empno=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, name);
        ps.setString(2, job);
        ps.setString(3, sal);
        ps.setInt(4, empno);
        ps.executeUpdate();
        ps.close();
        conn.close();

    }
}
