package com.jiazhong.huojian.jdbc.work;

import com.jiazhong.huojian.jdbc.work.been.Student;
import com.jiazhong.huojian.jdbc.work.dao.StudentDao;

import java.util.List;
import java.util.Scanner;

public class StudentApp {
    private static StudentDao studentDao = new StudentDao();

    private static void a() {
        StudentDao stuDao = new StudentDao();
        List<Student> all = stuDao.findAll();
        all.forEach(System.out::println);
    }

    private static Scanner scan = new Scanner(System.in);

    private static void b() {
        System.out.println("请输入姓名");
        String name = scan.next();
        System.out.println("请输入性别");
        String gender = scan.next();
        System.out.println("请输入生日 ");
        String birthday = scan.next();
        System.out.println("请输入地址 ");
        String address = scan.next();
        System.out.println("请输入电话");
        int phone = scan.nextInt();
        StudentDao studentDao = new StudentDao();
        Student student = new Student();
        student.setName(name);
        student.setGender(gender);
        student.setBirthday(birthday);
        student.setAddress(address);
        student.setPhone(phone);
        System.out.println(student);
        int row = studentDao.save(student);
        System.out.println(row);
    }

    private static void c() {
        boolean b = studentDao.removeById(6);
        System.out.println(b);
    }

    private static void d() {
        Student student = new Student();

        student.setName("安伟彤");
        student.setBirthday("2005-3-21");
        student.setGender("男");
        student.setAddress("西安");
        student.setPhone(5486486);
        student.setId(7);
        int upadte = studentDao.upadte(student);
        System.out.println("upadte = " + upadte);
    }

    private static void login() {
        System.out.println("请输入账号");
        String name = scan.next();
        System.out.println("请输入密码");
        String password = scan.next();
        Student student = studentDao.loadUsername1(name, password);
        System.out.println(student == null ? "登陆失败" : "登陆成功");
    }

    public static void main(String[] args) {
        login();
    }
}

