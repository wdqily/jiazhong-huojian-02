package com.jiazhong.huojian.jdbc.work.db;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;


// 专门负责获取数据库连接以及关闭数据库连接
public class DBManager {
    /**
     * 获取数据库连接
     * 提供账号、密码以及数据库的路径
     *
     * @return 数据库连接
     */
    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("驱动类没有找到");
        }
        Connection conn = null;
        try {
            String username = "root";
            String password = "20050217";
            String url = "jdbc:mysql://localhost:3306/jiazhong_2026_1?serverTimezone=Asia/Shanghai&useSSL=false&allowPublicKeyRetrieval=true";
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            System.out.println("数据库连接异常");
        }
        return conn;
    }

    /**
     * 通过数据库连接池的方式获取数据库连接
     *
     * @return 数据库连接
     */
    public static Connection getDruidConnection() {
//        1.加载配置文件
        try {
            Properties properties = new Properties();
            InputStream inputStream = DBManager.class.getClassLoader().getResourceAsStream("druid.properties");
            properties.load(inputStream);
            //2.获取数据源
            DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
            //3.返回连接
            return dataSource.getConnection();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    /**
     * 查询的关闭方法
     *
     * @param 需要关闭的连接
     * @param 需要关闭的邮递员
     * @param 需要关闭的结果集
     */
    public static void close(Connection conn, PreparedStatement ps, ResultSet rs) {
        try {
            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("关闭时出现了问题");
        }
    }
}
