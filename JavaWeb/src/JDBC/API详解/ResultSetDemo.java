package JDBC.API详解;

import JDBC.pojo.Employee;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @version v1.0
 * @ClassName: ResultSetDemo
 * @Description: TODO 类描述
 * @Author: Orange
 **/
public class ResultSetDemo {
    public static void main(String[] args) throws Exception{

    }

    /**
     * 查询emp数据表，封装为Employee对象，并且存户到ArrayList集合中，一般用pojo包来存放实体类
     * 1. 定义实体类
     * 2. 查询数据，封装到Employee对象中
     * 3. 将Employee对象存入ArrayList中
     * @throws Exception
     */
    @Test
    public void testResultSet2() throws Exception{
        Class.forName("com.mysql.cj.jdbc.Driver");

        String url = "jdbc:mysql://127.0.0.1:3306/db_study?useSSL=false";
        String username = "root";
        String password = "wwtooblivion";
        Connection conn = DriverManager.getConnection(url, username, password);

        String sql = "select * from emp";

        Statement stmt = conn.createStatement();

        ResultSet rs = stmt.executeQuery(sql);

        //创建集合
        List<Employee> list = new ArrayList<>();

        while(rs.next()){
            Employee employee = new Employee();
            int id = rs.getInt(1);
            String NAME = rs.getString(2);
            double salary = rs.getDouble(4);

            //赋值
            employee.setId(id);
            employee.setNAME(NAME);
            employee.setSalary(salary);

            list.add(employee);
        }

        System.out.println(list);

        rs.close();
        stmt.close();
        conn.close();
    }

    /**
     *
     * @throws Exception
     */
    @Test
    public void testResultSet1() throws Exception{
        //1. 注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");

        //2. 获取连接对象
        String url = "jdbc:mysql://127.0.0.1:3306/db_study?useSSL=false";
        String username = "root";
        String password = "wwtooblivion";
        Connection conn = DriverManager.getConnection(url, username, password);

        //3. 定义sql
        String sql = "select * from emp";

        //4. 获取执行sql的对象
        Statement stmt = conn.createStatement();

        //5. 执行sql
        ResultSet rs = stmt.executeQuery(sql);

        //6. 处理结果 遍历rs中的所有数据
        while(rs.next()){
            int id = rs.getInt(1);
            String NAME = rs.getString(2);
            double salary = rs.getDouble(4);
            System.out.println(id);
            System.out.println(NAME);
            System.out.println(salary);
            System.out.println("===");
        }

        //7. 释放资源
        rs.close();
        stmt.close();
        conn.close();
    }
}
