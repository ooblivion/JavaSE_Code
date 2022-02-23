package JDBC.API详解;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @version v1.0
 * @ClassName: ConnectionDemo
 * @Description: TODO 类描述
 * @Author: Orange
 **/
public class ConnectionDemo {
    public static void main(String[] args) throws Exception{
        //1. 注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");

        //2. 获取连接对象
        String url = "jdbc:mysql://127.0.0.1:3306/db_study?useSSL=false";
        String username = "root";
        String password = "wwtooblivion";
        Connection conn = DriverManager.getConnection(url, username, password);

        //3. 定义sql
        String sql1 = "update emp set salary = 90000 where id = 1";
        String sql2 = "update emp set salary = 80000 where id = 2";

        //4. 获取执行sql的对象
        Statement stmt = conn.createStatement();

        try {
            //保证事物的原子性（一个整体，但凡有异常就要要回滚事物
            //开启事物（关闭自动提交
            conn.setAutoCommit(false);

            int count1 = stmt.executeUpdate(sql1);
            System.out.println(count1);
            //int i = 3/0;
            int count2 = stmt.executeUpdate(sql2);
            System.out.println(count2);

            //提交事物
            conn.commit();

        } catch (Exception throwables) {
            //回滚事物
            conn.rollback();
            throwables.printStackTrace();
        }

        //7. 释放资源
        stmt.close();
        conn.close();

    }
}