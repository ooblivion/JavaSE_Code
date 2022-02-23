package JDBC.API详解;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @version v1.0
 * @ClassName: StatementDemo
 * @Description: TODO 类描述
 * @Author: Orange
 **/
public class StatementDemo {
    //由于要演示很多功能，所以代码改成单元测试的方法
    /**
     * 执行DDL语句，对数据的增删改
     * @throws Exception
     */
    @Test
    public void testDDL() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");

        String url = "jdbc:mysql://127.0.0.1:3306/db_study?useSSL=false";
        String username = "root";
        String password = "wwtooblivion";
        Connection conn = DriverManager.getConnection(url, username, password);

        String sql = "Drop database db2";
        Statement stmt = conn.createStatement();

        try {
            conn.setAutoCommit(false);
            //执行完DDL语句后返回可能是0，只要不报异常就ok
            int count = stmt.executeUpdate(sql);
            conn.commit();

        } catch (Exception throwables) {
            conn.rollback();
            throwables.printStackTrace();
        }
        stmt.close();
        conn.close();
    }


    /**
     * 执行DML语句，对数据的增删改
     * @throws Exception
     */
    @Test
    public void testDML() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");

        String url = "jdbc:mysql://127.0.0.1:3306/db_study?useSSL=false";
        String username = "root";
        String password = "wwtooblivion";
        Connection conn = DriverManager.getConnection(url, username, password);

        String sql1 = "update emp set salary = 1000 where id = 8";
        Statement stmt = conn.createStatement();

        try {
            conn.setAutoCommit(false);
            //执行完DML语句后受影响的行数
            int count1 = stmt.executeUpdate(sql1);

            if(count1>0){
                System.out.println("修改成功");
            }else {
                System.out.println("修改失败");
            }
            conn.commit();
        } catch (Exception throwables) {
            conn.rollback();
            throwables.printStackTrace();
        }
        stmt.close();
        conn.close();
    }
}


