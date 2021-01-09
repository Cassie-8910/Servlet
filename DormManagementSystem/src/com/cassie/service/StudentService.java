package com.cassie.service;

import com.cassie.model.Student;
import com.cassie.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentService {

    public static final StudentService studentService = new StudentService();

    /**
     * 展示学生列表
     * @param student
     * @return
     * @throws SQLException
     */
    public Student getStu(Student student) throws SQLException {
        Connection open = DBUtils.open();
        String sql = "select * from detail_info";
        PreparedStatement ps = open.prepareStatement(sql);
        ResultSet resultSet = ps.executeQuery();
        return student;
    }

    /**
     * 添加学生
     * @param student
     * @return
     * @throws SQLException
     */
    public Student add(Student student) throws SQLException {
        Connection open = DBUtils.open();
        //操作数据库，实现增删改查
        String sql = "insert into detail_info values(?,?,?,?,?,?,?)";
        PreparedStatement ps = open.prepareStatement(sql);
        ps.setString(1, student.getStuNum());
        ps.setString(2, student.getName());
        ps.setString(3, student.getGender());
        ps.setString(4, student.getDormNum());
        ps.setString(5, student.getAcademy());
        ps.setString(6, student.getMajor());
        ps.setString(7, student.getClassName());
        ps.execute();
        return student;
    }

    /**
     * 删除学生
     * @param student
     * @return
     * @throws SQLException
     */
    public Student delete(Student student) throws SQLException {
//        Connection open = DBUtils.open();
//        String sql = "delete from detail_info where stuNum = ?";
    }
}
