package com.cassie.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtils {
    // 注册驱动
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/dorm_info?characterEncoding=utf-8";
    static final String USER = "root";
    static final String PASS = "root";
    static Connection conn = null;

    /**
     * 打开数据库连接
     *
     * @return
     */
    public static Connection open() {
        try {
            Class.forName(JDBC_DRIVER);
            System.out.println("连接成功......");
            return DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (Exception e) {
            System.out.println("连接数据库失败....");
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 关闭数据库连接
     *
     * @return
     */
    public static Connection close() {
        if (conn != null) {
            try {
                conn.close();// 关闭数据库
                System.out.println("关闭...");
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("数据库关闭失败...");
            }
        }
        return null;
    }
}
