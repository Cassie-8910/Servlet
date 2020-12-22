package dormInfo;

import java.sql.*;

public class MySQLDemo {
    // 注册驱动
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/dorminfo?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=GMT%2B8";

    static final String USER = "root";
    static final String PASS = "root";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {
            // 注册JDBC驱动
            Class.forName(JDBC_DRIVER);

            //打开链接
            System.out.println("连接数据库");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            //执行查询
            System.out.println(" 实例化Statement对象...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT stuNum, name, gender FROM dorm_info";
            ResultSet rs = stmt.executeQuery(sql);


            // 展开结果集数据库
            while(rs.next()){
                // 通过字段检索
                String stuNum  = rs.getString("stuNum");
                String name = rs.getString("name");
                String gender = rs.getString("gender");

                // 输出数据
                System.out.print("学号: " + stuNum);
                System.out.print(", 姓名: " + name);
                System.out.print(", 性别: " + gender);
                System.out.print("\n");
            }
            // 完成后关闭
            rs.close();
            stmt.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            // 关闭资源
            try{
                if(stmt!=null) stmt.close();
            }catch(SQLException se2){
            }// 什么都不做
            try{
                if(conn!=null) conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
        System.out.println("Goodbye!");
    }
}
