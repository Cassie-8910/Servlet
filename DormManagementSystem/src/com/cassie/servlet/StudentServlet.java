package com.cassie.servlet;

import com.cassie.model.Student;
import com.cassie.service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class StudentServlet extends HttpServlet {

    /**
     * 获取stu列表
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("发送 get 请求");
        System.out.println("获取学生列表");
        resp.setHeader("Access-Control-Allow-Origin", "*");  //  星号表示所有的域都可以接受
        resp.setHeader("Access-Control-Allow-Methods", "GET,POST");
        req.setCharacterEncoding("utf-8");
    }

    /**
     * 添加stu
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("发送 post 请求");
        System.out.println("进入添加学生");
        resp.setHeader("Access-Control-Allow-Origin", "*");  //  星号表示所有的域都可以接受
        resp.setHeader("Access-Control-Allow-Methods", "GET,POST");
        req.setCharacterEncoding("utf-8");

        // 添加学生
        // 获得前台发送的数据
        String stuNum = req.getParameter("stuNum");
        String name = req.getParameter("name");
        String gender = req.getParameter("gender");
        String dormNum = req.getParameter("dormNum");
        String academy = req.getParameter("academy");
        String major = req.getParameter("major");
        String className = req.getParameter("className");


        Student student = new Student(stuNum, name, gender, dormNum, academy, major, className);
        System.out.println(student);
        try {
            Student add = StudentService.studentService.add(student);
            if(add!=null){
                resp.setContentType("application/json;charset=UTF-8");
                resp.setCharacterEncoding("utf-8");
                resp.getWriter().write("{\"message\":\"添加成功\"}");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("发送 delete 请求");
        System.out.println("进入删除学生");
        resp.setHeader("Access-Control-Allow-Origin", "*");  //  星号表示所有的域都可以接受
        resp.setHeader("Access-Control-Allow-Methods", "DELETE");
        req.setCharacterEncoding("utf-8");

        String stuNum = req.getParameter("stuNum");
    }
}
