package com.cassie.servlet;

import com.alibaba.fastjson.JSON;
import com.cassie.model.Student;
import com.cassie.service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentQueryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("进入查询");
        resp.setHeader("Access-Control-Allow-Origin", "*");  //  星号表示所有的域都可以接受
        resp.setHeader("Access-Control-Allow-Methods", "*");
        resp.setContentType("application/json;charset=UTF-8");
        resp.setCharacterEncoding("utf-8");

        if (!LoginServlet.authentication(req,resp)){
            Map<String,Object> maps = new HashMap<>();
            maps.put("message","未授权，请先登录");
            resp.setStatus(401);
            resp.getWriter().write(JSON.toJSONString(maps));
            return;
        }

        List<Student> students=null;
        try {
            System.out.println("======"+req.getParameter("stuNum"));

            if(req.getParameter("stuNum")!=null) { // 按学号查询
                students = StudentService.studentService.selectByStuNum(req.getParameter("stuNum"));
            }else if(req.getParameter("dormNum")!=null){ // 按宿舍号码
                students = StudentService.studentService.selectByDormNum(req.getParameter("dormNum"));
            }else if(req.getParameter("className")!=null){ // 班级
                students = StudentService.studentService.selectByClassName(req.getParameter("className"));
            }else if(req.getParameter("name")!=null){ // 姓名
                students = StudentService.studentService.selectByName(req.getParameter("name"));
            }else {
                resp.setStatus(500);
                resp.getWriter().write("{\"message\":\"非法查询\"}");
                System.out.println("非法查询");
            }
        } catch (Exception e) {
            e.printStackTrace();
            resp.setStatus(500);
            resp.getWriter().write("{\"message\":\"查询失败，数据库异常\"}");
        }
        Map<String,Object> maps = new HashMap<>();
        maps.put("message","查询成功");
        maps.put("data",students);
        System.out.println("查询成功");
        resp.getWriter().write(JSON.toJSONString(maps));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }


}
