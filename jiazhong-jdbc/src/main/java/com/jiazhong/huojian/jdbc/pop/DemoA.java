package com.jiazhong.huojian.jdbc.pop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//向数据库中删除一行信息
public class DemoA {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        //1.加载驱动 Driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassCastException e) {
            System.out.println("驱动类没有找到");
        }
        // 2. 建立Java和数据库之间的连接通道
        String username = "root";//数据库账号
        String password = "20050217";//数据库密码
        String url = "jdbc:mysql://localhost:3306/jiazhong_2026_1";//数据库路径
        Connection conn = DriverManager.getConnection(url, username, password);
        System.out.println("成功建立Java和数据库之间的连接，" + conn);
        //3.创建一个负责传输命令的传令官(将java的命令传达到MySQL中执行，并且将执行的结果返回给Java)
        String sql = "delete from emp where empno=7839";//SQL命令
        PreparedStatement ps = conn.prepareStatement(sql);//产生了一名骑手，这个骑手已经携带了SQL命令
        //4.将命令交由数据库执行
        int row = ps.executeUpdate();
        System.out.println(row);//row==0代表失败 row>0代表成功
        //5.关闭和数据库之间的连接
        ps.close();
        conn.close();
    }
}
