//package com.cassie.servlet;
//
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.sql.SQLException;
//
//public class AddNewStu extends  HttpServlet {
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//        System.out.println("发送 post 请求");
//        System.out.println("进入添加学生");
//        resp.setCharacterEncoding("UTF-8");
//        resp.setHeader("Access-Control-Allow-Origin", "*");  //  星号表示所有的域都可以接受
//        resp.setHeader("Access-Control-Allow-Methods", "GET,POST");
//        req.setCharacterEncoding("utf-8");
//
//        // 添加学生
//        // 获得前台发送的数据
////        String tempStuNum = req.getParameter("stuNum");
//        String stuNum = req.getParameter("stuNum");
//        String name = req.getParameter("name");
//        String gender = req.getParameter("gender");
//        String dormNum = req.getParameter("dormNum");
//        String academy = req.getParameter("academy");
//        String major = req.getParameter("major");
//        String className = req.getParameter("className");
//
//        JDBC jd = null;
//        try {
//            jd = new JDBC();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        Student student = new Student(stuNum, name, gender, dormNum, academy, major, className);
//        try {
//            jd.add(student);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    protected void doGet (HttpServletRequest req, HttpServletResponse resp) throws IOException {
//        System.out.println("发送 get 请求");
//        req.setCharacterEncoding("utf-8");
//        doGet(req, resp);
//        resp.setContentType("text/html;charset=utf-8");
//        PrintWriter out = resp.getWriter();
//        out.println("<h1>Hello Cassie</h1>");
//    }
//}
//
