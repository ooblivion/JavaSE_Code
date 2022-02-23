package JDBC.API详解;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * @version v1.0
 * @ClassName: DriveManagerDemo
 * @Description: TODO 类描述
 * @Author: Orange
 **/
public class DriveManagerDemo {
    public static void main(String[] args) throws Exception{
        //1. 注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");

        //2. 获取连接对象
        String url = "jdbc:mysql://127.0.0.1:3306/db_study?useSSL=false";
        String username = "root";
        String password = "wwtooblivion";
        Connection conn = DriverManager.getConnection(url, username, password);

        //3. 定义sql
        String sql = "update emp set salary = 20000 where id = 1";

        //4. 获取执行sql的对象
        Statement stmt = conn.createStatement();

        //5. 执行sql 返回值是收影响的行数
        int count = stmt.executeUpdate(sql);

        //6. 处理结果
        System.out.println(count);

        //7. 释放资源
        stmt.close();
        conn.close();

    }
}
