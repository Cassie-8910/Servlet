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

public class StudentServlet extends HttpServlet {

    /**
     * 获取stu列表
     * done.
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("进入获取全部学生列表");
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
            students = StudentService.studentService.selectAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Map<String,Object> maps = new HashMap<>();
        maps.put("data",students);
        resp.getWriter().print(JSON.toJSONString(maps));
    }

    /**
     * 添加stu
     * done.
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("进入添加学生");
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

        if(stuNum==null || name==null || gender==null || dormNum==null || academy ==null || major==null || className==null) {
            Student student = new Student(stuNum, name, gender, dormNum, academy, major, className);
            System.out.println(student);
            resp.setStatus(500);
            resp.getWriter().write("{\"message\":\"添加失败,参数不能为空\"}");
            return;
        }
        if(stuNum.length() != 12) {
            Student student = new Student(stuNum, name, gender, dormNum, academy, major, className);
            System.out.println(student);
            resp.setStatus(500);
            resp.getWriter().write("{\"message\":\"添加失败,学号必须是12位\"}");
            return;
        }

        Student student = new Student(stuNum, name, gender, dormNum, academy, major, className);
        System.out.println(student);
        try {
            Student add = StudentService.studentService.add(student);
            if(add!=null){
                System.out.println("添加成功");
                resp.getWriter().write("{\"message\":\"添加成功\"}");
            }
        } catch (Exception e) {
            e.printStackTrace();
            resp.setStatus(500);
            resp.getWriter().write("{\"message\":\"添加失败\"}");
        }

    }

    /**
     * 修改
     * done.
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("进入修改学生");
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

        req.setCharacterEncoding("utf-8");

        String stuNum = req.getParameter("stuNum");
        String name = req.getParameter("name");
        String gender = req.getParameter("gender");
        String dormNum = req.getParameter("dormNum");
        String academy = req.getParameter("academy");
        String major = req.getParameter("major");
        String className = req.getParameter("className");

        if(stuNum==null || name==null || gender==null || dormNum==null || academy ==null || major==null || className==null) {
            Student student = new Student(stuNum, name, gender, dormNum, academy, major, className);
            System.out.println(student);
            resp.setStatus(500);
            Map<String,Object> maps = new HashMap<>();
            maps.put("message","修改失败,参数不能为空");
            resp.getWriter().write(JSON.toJSONString(maps));
            return;
        }

        Student student = new Student(stuNum, name, gender, dormNum, academy, major, className);
        System.out.println(student);
        try {
            Student stu = StudentService.studentService.update(student);
            if(stu!=null){
                Map<String,Object> maps = new HashMap<>();
                maps.put("message","修改成功");
                maps.put("data",stu);
                System.out.println("修改成功");
                resp.getWriter().write(JSON.toJSONString(maps));
            }
        } catch (Exception e) {
            e.printStackTrace();
            resp.setStatus(500);
            resp.getWriter().write("{\"message\":\"修改失败\"}");
        }

    }

    /**
     * done.
     * 删除
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("进入删除学生");
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

        req.setCharacterEncoding("utf-8");

        String stuNum = req.getParameter("stuNum");
        String stu = "";
        try {
            stu = StudentService.studentService.delete(stuNum);
            if(!stu.equals("")){
                Map<String,Object> maps = new HashMap<>();
                maps.put("message","删除成功");
                maps.put("data",stu);
                System.out.println("删除成功");
                resp.getWriter().write(JSON.toJSONString(maps));
            }
        } catch (Exception throwables) {
            throwables.printStackTrace();
            resp.setStatus(500);
            resp.getWriter().write("{\"message\":\"删除失败\"}");
        }

    }

    @Override
    public void doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("options请求");
        resp.setHeader("Access-Control-Allow-Origin", "*");  //  星号表示所有的域都可以接受
        resp.setHeader("Access-Control-Allow-Methods", "*");
        resp.setHeader("Access-Control-Allow-Headers", "*");
        resp.setContentType("application/json;charset=UTF-8");
        resp.setCharacterEncoding("utf-8");
    }

}
