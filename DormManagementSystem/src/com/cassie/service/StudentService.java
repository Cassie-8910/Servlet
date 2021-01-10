package com.cassie.service;

import com.cassie.model.Student;
import com.cassie.utils.DBUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentService {

    public static final StudentService studentService = new StudentService();

    /**
     * 修改学生
     * @param student
     * @return
     * @throws SQLException
     */
    public Student update(Student student) throws SQLException {
        Connection open = DBUtils.open();
        String sql = "update detail_info set name=?,dormNum=?,academy=?,major=?" +
                ",className=?,gender=? where stuNum=?";
        PreparedStatement ps = open.prepareStatement(sql);
        ps.setString(1,student.getName());
        ps.setString(2,student.getDormNum());
        ps.setString(3,student.getAcademy());
        ps.setString(4,student.getMajor());
        ps.setString(5,student.getClassName());
        ps.setString(6,student.getGender());
        ps.setString(7,student.getStuNum());

        ps.execute();
        // 返回新数据
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
     * @param stuNum
     * @return
     * @throws SQLException
     */
    public String delete(String stuNum) throws SQLException {
        Connection open = DBUtils.open();
        String sql = "delete from detail_info where stuNum =?";
        PreparedStatement ps = open.prepareStatement(sql);
        ps.setString(1, stuNum);
        ps.execute();
        return stuNum;
    }

    /**
     * 获取所有的学生
     * @return
     * @throws SQLException
     */
    public List<Student> selectAll() throws SQLException {
        List<Student> list = new ArrayList<>();
        Connection open = DBUtils.open();
        String sql = "select * from detail_info";
        PreparedStatement ps = open.prepareStatement(sql);
        ResultSet resultSet = ps.executeQuery();
        while(resultSet.next()){
            Student student = new Student();
            student.setStuNum(resultSet.getString("stuNum"));
            student.setName(resultSet.getString("name"));
            student.setGender(resultSet.getString("gender"));
            student.setDormNum(resultSet.getString("dormNum"));
            student.setAcademy(resultSet.getString("academy"));
            student.setMajor(resultSet.getString("major"));
            student.setClassName(resultSet.getString("className"));
            list.add(student);
        }
        return list;
    }

    /**
     * 按照学号查询
     * 模糊查询
     * done.
     * @param stuNum
     * @return
     * @throws SQLException
     */
    public List<Student> selectByStuNum(String stuNum) throws SQLException {
        List<Student> list = new ArrayList<>();
        Connection open = DBUtils.open();
        String sql = "select * from detail_info where stuNum like ?";
        PreparedStatement ps = open.prepareStatement(sql);
        ps.setString(1,"%"+stuNum+"%");
        ResultSet resultSet = ps.executeQuery();
        while(resultSet.next()){
            Student student = new Student();
            student.setStuNum(resultSet.getString("stuNum"));
            student.setName(resultSet.getString("name"));
            student.setGender(resultSet.getString("gender"));
            student.setDormNum(resultSet.getString("dormNum"));
            student.setAcademy(resultSet.getString("academy"));
            student.setMajor(resultSet.getString("major"));
            student.setClassName(resultSet.getString("className"));
            list.add(student);
        }
        return list;
    }

    /**
     * 按照宿舍号查询
     * 模糊查询
     * done.
     * @param dormNum
     * @return
     * @throws SQLException
     */
    public List<Student> selectByDormNum(String dormNum) throws SQLException {
        List<Student> list = new ArrayList<>();
        Connection open = DBUtils.open();
        String sql = "select * from detail_info where dormNum like ?";
        PreparedStatement ps = open.prepareStatement(sql);
        ps.setString(1,"%"+dormNum+"%");
        ResultSet resultSet = ps.executeQuery();
        while(resultSet.next()){
            Student student = new Student();
            student.setStuNum(resultSet.getString("stuNum"));
            student.setName(resultSet.getString("name"));
            student.setGender(resultSet.getString("gender"));
            student.setDormNum(resultSet.getString("dormNum"));
            student.setAcademy(resultSet.getString("academy"));
            student.setMajor(resultSet.getString("major"));
            student.setClassName(resultSet.getString("className"));
            list.add(student);
        }
        return list;
    }

    /**
     * 按照班级查询
     * 模糊查询
     * done.
     * @param className
     * @return
     * @throws SQLException
     */
    public List<Student> selectByClassName(String className) throws SQLException {
        List<Student> list = new ArrayList<>();
        Connection open = DBUtils.open();
        String sql = "select * from detail_info where className like ?";
        PreparedStatement ps = open.prepareStatement(sql);
        ps.setString(1,"%"+className+"%");
        ResultSet resultSet = ps.executeQuery();
        while(resultSet.next()){
            Student student = new Student();
            student.setStuNum(resultSet.getString("stuNum"));
            student.setName(resultSet.getString("name"));
            student.setGender(resultSet.getString("gender"));
            student.setDormNum(resultSet.getString("dormNum"));
            student.setAcademy(resultSet.getString("academy"));
            student.setMajor(resultSet.getString("major"));
            student.setClassName(resultSet.getString("className"));
            list.add(student);
        }
        return list;
    }

    /**
     * 按照学生姓名查询
     * 模糊查询
     * done.
     * @param name
     * @return
     * @throws SQLException
     */
    public List<Student> selectByName(String name) throws SQLException {
        List<Student> list = new ArrayList<>();
        Connection open = DBUtils.open();
        String sql = "select * from detail_info where name like ?";
        PreparedStatement ps = open.prepareStatement(sql);
        ps.setString(1,"%"+name+"%");
        ResultSet resultSet = ps.executeQuery();
        while(resultSet.next()){
            Student student = new Student();
            student.setStuNum(resultSet.getString("stuNum"));
            student.setName(resultSet.getString("name"));
            student.setGender(resultSet.getString("gender"));
            student.setDormNum(resultSet.getString("dormNum"));
            student.setAcademy(resultSet.getString("academy"));
            student.setMajor(resultSet.getString("major"));
            student.setClassName(resultSet.getString("className"));
            list.add(student);
        }
        return list;
    }
}
