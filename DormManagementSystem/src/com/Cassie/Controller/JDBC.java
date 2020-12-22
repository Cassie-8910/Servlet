package com.Cassie.Controller;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBC {
    // 注册驱动
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/dorminfo?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=GMT%2B8";
    static final String USER = "root";
    static final String PASS = "root";
    private static Connection connection;

    public JDBC() throws ClassNotFoundException, SQLException {
        Class.forName(JDBC_DRIVER);
        connection = DriverManager.getConnection(DB_URL, USER, PASS);
//        Statement statement = connection.createStatement();
    }

    /**
     * 增加学生
     *
     * @return
     */
    public boolean add(Student student) throws SQLException {
        //3.操作数据库，实现增删改查
        String sql = "insert into dorm_info values(?,?,?,?,?,?,?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, student.stuNum);
        ps.setString(2, student.name);
        ps.setString(3, student.gender);
        ps.setString(4, student.dormNum);
        ps.setString(5, student.academy);
        ps.setString(6, student.major);
        ps.setString(7, student.className);
        return ps.execute();
    }

    /**
     * 删除学生
     *
     * @return
     */
    public boolean delete(int stuNum) throws SQLException {
        String sql = "delete from dorm_info where stuNum='" + stuNum + "'";
        Statement statement = connection.createStatement();
        return statement.execute(sql);
    }

    /**
     * 根据stuNum查询学生
     *
     * @param stuNum stuNum
     * @return student
     */
    public Student selectById(int stuNum) throws SQLException {
        String sql = "select * from student_info where stuNum='" + stuNum + "'";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            return new Student(resultSet.getString("id")
                    , resultSet.getString("name")
                    , resultSet.getString("gender")
                    , resultSet.getString("dormNum")
                    , resultSet.getString("academy")
                    , resultSet.getString("major")
                    , resultSet.getString("className")
            );
        }
        return null;
    }

    /**
     * 根据多个stuNums查询
     *
     * @param stuNums stuNums
     * @return 学生集合
     */
    public List<Student> selectByStuNums(List<Integer> stuNums) throws SQLException {
        if (stuNums == null || stuNums.size() == 0) {
            return null;
        }
        List<Student> students = new ArrayList<>();
        Statement statement = connection.createStatement();
        stuNums.forEach(k -> {
            try {
                String sql = "select * from  where stuNums='" + k + "'";
                ResultSet resultSet = null;
                resultSet = statement.executeQuery(sql);
                while (resultSet.next()) {
                    students.add(new Student(resultSet.getString("stuNums")
                            , resultSet.getString("name")
                            , resultSet.getString("gender")
                            , resultSet.getString("dormNum")
                            , resultSet.getString("academy")
                            , resultSet.getString("major")
                            , resultSet.getString("className")
                        ));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
        return students;
    }
}

class Student {
    String stuNum;
    String name;
    String gender;
    String dormNum;
    String academy;
    String major;
    String className;

    public Student(String stuNums, String setString, String resultSetString, String string, String stuNum, String name, String gender) {
        this.stuNum = stuNum;
        this.name = name;
        this.gender = gender;
        this.dormNum = dormNum;
        this.academy = academy;
        this.major = major;
        this.className = className;
    }
}
