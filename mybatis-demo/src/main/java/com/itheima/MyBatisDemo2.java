package com.itheima;

import com.itheima.mapper.UserMapper;
import com.itheima.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @version v1.0
 * @ClassName: MyBatisDemo2
 * @Description: TODO 类描述
 * @Author: Orange
 **/
public class MyBatisDemo2 {
    public static void main(String[] args) throws IOException {
        //1. 加载mybatis的核心配置文件，获取SqlSessionFactory，从官网复制，工厂只加载一次
        String resource = "mybatis-config.xml";//相对路径
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2. 获取SqlSession对象来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3. 执行sql
        //3.1 获取接口代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //3.2 执行方法，其实就是执行sql语句
        User users = userMapper.selectById(1);

        //4. 释放资源
        sqlSession.close();
    }
}