package com.jiazhong.huojian.jdbc.pop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DemoD {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String username = "root";
        String password = "20050217";
        String url = "jdbc:mysql://localhost:3306/jiazhong_2026_1?serverTimezone=Asia/Shanghai&useSSL=false&allowPublicKeyRetrieval=true";
        Connection conn = DriverManager.getConnection(url, username, password);
        String sql = "select* from emp";
        PreparedStatement ps = conn.prepareStatement(sql);
        //执行完毕查询后，会得到一个结果集
        ResultSet rs = ps.executeQuery();
        //遍历结果集
        while (rs.next()) { //有没有下一行
            //获取到下一行
            //获取到下一行的某一列
            int empno = rs.getInt(1);//1代表的索引
            String ename = rs.getString("ename");//ename代表的列名
            String job = rs.getString("job");
            int mgr = rs.getInt(4);
            String hiredate = rs.getString("hiredate");
            double sal = rs.getDouble("sal");
            double comm = rs.getDouble("comm");
            int deptno = rs.getInt(8);
            System.out.println("empno\tename\tjob\t\tmgr\t\t·hiredate\tsal\tcomm\tdeptno");
            System.out.print(empno + "\t");
            System.out.print(ename + "\t");
            System.out.print(job + "\t");
            System.out.print(mgr + "\t");
            System.out.print(hiredate + "\t");
            System.out.print(sal + "\t");
            System.out.print(comm + "\t");
            System.out.println(deptno + "\t");
        }
        rs.close();
        ps.close();
        conn.close();
    }

}
