package com.jiazhong.huojian.jdbc.work.dao;

import com.jiazhong.huojian.jdbc.oop.db.DBManager;
import com.jiazhong.huojian.jdbc.work.been.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {
    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;

    public Student findStudentByid(int id) {
        conn = DBManager.getConnection();
        String sql = "select* from Student where id=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                int ID = rs.getInt(1);
                String name = rs.getString(2);
                String password = rs.getString(3);
                String gender = rs.getString(4);
                String birthday = rs.getString(5);
                String address = rs.getString(6);
                int phone = rs.getInt(7);
                DBManager.close(conn, ps, rs);
                return new Student(id, name, password, gender, birthday, address, phone);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public List<Student> findAll() {
        List<Student> list = new ArrayList<>();
        conn = DBManager.getConnection();
        String sql = "select* from Student";
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int ID = rs.getInt(1);
                String name = rs.getString(2);
                String password = rs.getString(3);
                String gender = rs.getString(4);
                String birthday = rs.getString(5);
                String address = rs.getString(6);
                int phone = rs.getInt(7);
                Student student = new Student(ID, name, password, gender, birthday, address, phone);
                list.add(student);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        DBManager.close(conn, ps, rs);
        return list;
    }

    public int save(Student student) {
        conn = DBManager.getConnection();
        String sql = "insert into Student values(null,?,?,?,?,?,?)";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, student.getName());
            ps.setString(2, student.getPassword());
            ps.setString(3, student.getGender());
            ps.setString(4, student.getBirthday());
            ps.setString(5, student.getAddress());
            ps.setInt(6, student.getPhone());
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }

    public boolean removeById(int id) {
        conn = DBManager.getConnection();
        String sql = "delete from student where id=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public int upadte(Student student) {
        Connection conn = DBManager.getConnection();
        String sql = "update student set name=?,gender=?,birthday=?,address=?,phone=? where id=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, student.getName());
            ps.setString(2, student.getGender());
            ps.setString(3, student.getBirthday());
            ps.setString(4, student.getAddress());
            ps.setInt(5, student.getPhone());
            ps.setInt(6, student.getId());
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }

    //登录
    //SQL注入风险的
    public Student loadUsername1(String name, String password) {
        conn = DBManager.getConnection();
        //sff'or'1'='1
        String sql = "select * from student where `name`='" + name + "' and `password`='" + password + "'";
        System.out.println(sql);
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                Student stu = new Student();
                stu.setId(rs.getInt(1));
                stu.setName(rs.getString(2));
                // stu.setPassword(rs.getString(3));
                stu.setGender(rs.getString(4));
                stu.setBirthday(rs.getString(5));
                stu.setAddress(rs.getString(6));
                stu.setPhone(rs.getInt(7));
                return stu;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public Student loadUsername2(String name, String password) {
        conn = DBManager.getConnection();
        String sql = "select * from student where `name`=? and `password`=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, password);
            rs = ps.executeQuery();
            if (rs.next()) {
                Student stu = new Student();
                stu.setId(rs.getInt(1));
                stu.setName(rs.getString(2));
                // stu.setPassword(rs.getString(3));
                stu.setGender(rs.getString(4));
                stu.setBirthday(rs.getString(5));
                stu.setAddress(rs.getString(6));
                stu.setPhone(rs.getInt(7));
                return stu;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public Student loadUsername3(String name, String password) {
        conn = DBManager.getConnection();
        String sql = "select * from student where `name`=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            rs = ps.executeQuery();
            if (rs.next()) {
                //通过java查询密码是否正确
                String salPass = rs.getString(3);
                if (!salPass.equals(password)) {
                    return null;
                }
                Student stu = new Student();
                stu.setId(rs.getInt(1));
                stu.setName(rs.getString(2));
                // stu.setPassword(rs.getString(3));
                stu.setGender(rs.getString(4));
                stu.setBirthday(rs.getString(5));
                stu.setAddress(rs.getString(6));
                stu.setPhone(rs.getInt(7));
                return stu;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
