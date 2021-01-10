package com.cassie.servlet;

import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LoginServlet extends HttpServlet {

    private static final String TOKEN = "JAVAISTHEBESTINTHEWORLD";

    private static final String USERNAME = "admin";

    private static final String PASSWORD = "admin";

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("进入登录");
        resp.setHeader("Access-Control-Allow-Origin", "*");  //  星号表示所有的域都可以接受
        resp.setHeader("Access-Control-Allow-Methods", "*");
        resp.setContentType("application/json;charset=UTF-8");
        resp.setCharacterEncoding("utf-8");

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        Map<String,Object> maps = new HashMap<>();
        if (!isCorrect(username,password)){
            resp.setStatus(403); // 授权失败
            maps.put("message","用户名或密码错误");
            resp.getWriter().write(JSON.toJSONString(maps));
            return;
        }
        resp.setStatus(200);
        maps.put("message","登录成功");
        maps.put("token",TOKEN);
        resp.getWriter().write(JSON.toJSONString(maps));
    }

    /**
     * 用户名密码校验
     * @param username
     * @param password
     * @return
     */
    private boolean isCorrect(String username,String password){
        if(username == null || password == null ){
            return false;
        }
        if(username.equals("")||password.equals("")){
            return false;
        }
        if(username.isEmpty()||password.isEmpty()){
            return false;
        }

        return USERNAME.equals(username)&&PASSWORD.equals(password);
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

    /**
     * 权限校验
     * @param req
     * @param reps
     * @return
     */
    public static  boolean authentication(HttpServletRequest req,HttpServletResponse reps){

        String authentication = req.getHeader("Authentication");
        if(authentication==null || authentication.isEmpty()){
            return false;
        }
        return LoginServlet.TOKEN.equals(authentication);
    }
}
