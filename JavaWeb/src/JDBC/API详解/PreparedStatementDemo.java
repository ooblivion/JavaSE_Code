package JDBC.API详解;

import org.junit.Test;

import java.sql.*;

/**
 * @version v1.0
 * @ClassName: PreparedStatementDemo
 * @Description: 进行预编译SQL语句的对象
 * @Author: Orange
 **/
public class PreparedStatementDemo {


    @Test
    public void testPrepareStatement() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");

        String url = "jdbc:mysql://127.0.0.1:3306/db_study?useSSL=false";
        String username = "root";
        String password = "wwtooblivion";
        Connection conn = DriverManager.getConnection(url, username, password);

//        String name ="mike";
//        String pwd = "123";
        String name = "xxxxx";
        String pwd = "' or '1' = '1";

//        String sql = "SELECT * FROM tb_user";
//        String sql = "SELECT * FROM tb_user WHERE username= '"+name+"' and password = '"+pwd +"'";
        String sql = "SELECT * FROM tb_user WHERE username= ? and password = ?";

        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1,name);//设置第一个?
        pstmt.setString(2,pwd);//设置第二个?

        ResultSet rs = pstmt.executeQuery();

        //判断登录是否成功
        if(rs.next()){
            System.out.println("successful");
        }else {
            System.out.println("failure");
        }

        //释放资源
        rs.close();
        pstmt.close();
        conn.close();
    }


    /**
     * 简单演示一些SQL注入
     * @throws Exception
     */
    @Test
    public void testLogin_inject() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");

        String url = "jdbc:mysql://127.0.0.1:3306/db_study?useSSL=false";
        String username = "root";
        String password = "wwtooblivion";
        Connection conn = DriverManager.getConnection(url, username, password);

        String name ="mike";
        String pwd = "123";
//        String name = "xxxxx";
//        String pwd = "' or '1' = '1";
//        String sql = "SELECT * FROM tb_user";
        String sql = "SELECT * FROM tb_user WHERE username= '"+name+"' and password = '"+pwd +"'";

        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        //判断登录是否成功
        if(rs.next()){
            System.out.println("successful");
        }else {
            System.out.println("failure");
        }

        //释放资源
        rs.close();
        stmt.close();
        conn.close();

    }
}
