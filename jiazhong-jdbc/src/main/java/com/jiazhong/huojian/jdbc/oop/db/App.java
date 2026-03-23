package com.jiazhong.huojian.jdbc.oop.db;

import com.jiazhong.huojian.jdbc.bean.Emp;
import com.jiazhong.huojian.jdbc.oop.dao.EmpDao;

import java.util.List;
import java.util.Scanner;

public class App {
    private static void a() {
        EmpDao edao = new EmpDao();
        List<Emp> all = edao.findAll();
        all.forEach(System.out::println);
    }

    private static Scanner scan = new Scanner(System.in);

    //调的EmpDao第二个
    private static void b1() {
        System.out.println("请输入姓名");
        String name = scan.next();
        System.out.println("请输入工作");
        String job = scan.next();
        System.out.println("请输入上司id");
        int mgr = scan.nextInt();
        System.out.println("请输入入职时间");
        String hiredate = scan.next();
        System.out.println("请输入工资");
        int sal = scan.nextInt();
        System.out.println("请输入奖金");
        int comm = scan.nextInt();
        System.out.println("请输入部门id");
        int dept = scan.nextInt();
        EmpDao edao = new EmpDao();
        int row = edao.save(name, job, mgr, hiredate, sal, comm, dept);
        System.out.println(row);
    }

    //调的EmpDao第一个
    private static void b2() {
        System.out.println("请输入姓名");
        String name = scan.next();
        System.out.println("请输入工作");
        String job = scan.next();
        System.out.println("请输入上司id");
        int mgr = scan.nextInt();
        System.out.println("请输入入职时间");
        String hiredate = scan.next();
        System.out.println("请输入工资");
        int sal = scan.nextInt();
        System.out.println("请输入奖金");
        int comm = scan.nextInt();
        System.out.println("请输入部门id");
        int dept = scan.nextInt();
        EmpDao edao = new EmpDao();
        Emp emp = new Emp();
        emp.setEname(name);
        emp.setJob(job);
        emp.setMgr(mgr);
        emp.setHireDate(hiredate);
        emp.setSal(sal);
        emp.setComm(comm);
        emp.setDeptNo(dept);
        System.out.println(emp);
        int row = edao.save(emp);
        System.out.println("row = " + row);
    }

    public static void main(String[] args) {
        a();
    }
}
