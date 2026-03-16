package com.jiazhong.huojian.jdbc.oop.dao;

import com.jiazhong.huojian.jdbc.been.Emp;
import com.jiazhong.huojian.jdbc.oop.db.DBManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// Data Object Access === Mapper
public class EmpDao {
    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;

    public Emp findEmpByEmpno(int empNo) {
        conn = DBManager.getConnection();
        String sql = "select* from emp where empno=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, empNo);
            rs = ps.executeQuery();
            if (rs.next()) {
                int no = rs.getInt(1);
                String ename = rs.getString(2);
                String job = rs.getString(3);
                int mgr = rs.getInt(4);
                String hireDate = rs.getString(5);
                int sal = rs.getInt(6);
                int comm = rs.getInt(7);
                int deptNo = rs.getInt(8);
                DBManager.close(conn, ps, rs);
                return new Emp(no, ename, job, mgr, hireDate, sal, comm, deptNo);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public List<Emp> findAll() {
        List<Emp> list = new ArrayList<>();
        conn = DBManager.getDruidConnection();
        String sql = "select* from emp";
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
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
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        DBManager.close(conn, ps, rs);
        return list;
    }

    public int save(Emp emp) {
        conn = DBManager.getConnection();
        String sql = "insert into emp values(null,?,?,?,?,?,?,?)";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, emp.getEname());
            ps.setString(2, emp.getJob());
            ps.setInt(3, emp.getMgr());
            ps.setString(4, emp.getHireDate());
            ps.setInt(5, emp.getSal());
            ps.setInt(6, emp.getComm());
            ps.setInt(7, emp.getDeptNo());
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }

    public int save(String ename, String job, int mgr, String hireDate, int sal, int comm, int deptNo) {
        conn = DBManager.getConnection();
        String sql = "insert into emp values(null,?,?,?,?,?,?,?)";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, ename);
            ps.setString(2, job);
            ps.setInt(3, mgr);
            ps.setString(4, hireDate);
            ps.setInt(5, sal);
            ps.setInt(6, comm);
            ps.setInt(7, deptNo);
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }

}

