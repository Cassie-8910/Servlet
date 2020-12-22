package com.controller;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 子类 =》父类-》A接口
 * 子类也是A接口实现类
 *
 * 抽象类作用： 降低接口实现类对接口实现过程难度
 *              将接口中不需要使用抽象方法交给抽象类进行完成
 *              这样接口实现类只需要对接口需要方法进行重写
 *
 * 编写一个servlet程序三个步骤:
 *      1. 自定义一个类继承 HttpServlet
 *      2. 重写 doGet() doPost()方法
 *      3. 在web.xml中注册servlet
 */
public class OneServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("OneServlet类针对浏览器发送 get 请求");
        PrintWriter out = resp.getWriter();
        out.println("<h1>Hello Cassie</h1>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("OneServlet类针对浏览器发送 post 请求");
    }
}
//public class OneServlet implements Servlet {
//// 直接继承一个接口就要实现接口中所有的方法
////    我们只要 Servlet接口中的一个 就是 service
////    继承这个抽象类的时候就不要进行Servlet中所有方法重写了
//    @Override
//    public void init(ServletConfig servletConfig) throws ServletException {
//
//    }
//
//    @Override
//    public ServletConfig getServletConfig() {
//        return null;
//    }
//
//    //   tomcat Servlet oneServlet = new OneServlet()
//    // tomcat Onservlet.service()处理需求
//    @Override
//    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
//        // 有用
//    }
//
//    @Override
//    public String getServletInfo() {
//        return null;
//    }
//
//    @Override
//    public void destroy() {
//
//    }
//}

