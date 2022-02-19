# 数据库

## MySQL

### MySQL安装

- 下载5.0版本的压缩包
- 添加环境变量
- 添加配置文件到mysql根目录
- 初始化MySQL：`mysqld --initialize-insecure`
- 注册MySQL服务：`mysqld -install`
- 启动MySQL服务：`net start mysql` （停止MySQL服务：`net stop mysql`
- 修改默认账户密码：`mysqladmin -u root password 1234`
- 登录MySQL：`mysql -uroot -p1234`
  - 登录参数：`mysql -u用户名 -p密码 -h要连接的mysql服务器的ip地址(默认127.0.0.1) -P端口号(默认3306)`
- 退出MySQL：`exit quit`

卸载MySQL

- `net stop mysql`
- `mysql -remove mysql`
- 删除MySQL目录以及相关配置文件

### MySQL数据模型

- 关系型数据库：建立在关系模型基础上的数据库，关系型数据库是由多张能相互关联的**二维表**组成的数据库
- 优点
  - 都是使用表结构，格式一致，便于维护
  - 使用SQL语句，便于复杂查询
  - 数据存储在磁盘中安全（持久化

### SQL简介&语法

- 通用语法
  - 可以单行或多行书写，以分号结尾
  - 不区分大小写，关键字建议用大写
  - 注释 `-- comment /*comment*/`

#### DDL 数据定义语言 用来定义数据库对象：数据库，表，列

- 查询
  - `show databases;`
- 创建
  - `create database db1;`
  - `create database if not exists db1;`
- 删除
  - `drop database db1;`
  - `drop database if not exists db2;`
- 使用数据库
  - `use db1; `
  - `select database();` 查看当前使用的数据库

#### DML 数据操作语言 用来对数据库中的数据表进行增删改

- 创建Create

  - `CREATE TABLE 表名 (字段名1 数据类型1, 字段名2 数据类型2);`

    ```sql
    create database if not exists db1;
    USE db1
    CREATE TABLE tb_user(
        id int,
        username varchar(20),
        password varchar(32)
    );
    SHOW TABLE;
    DESC tb_user;
    ```

    s

    s

    s

    s

- 查询Retrieve
  - `show tables`
  - `use 数据库名`
  - `show tables`
  - 查询表结构 `desc 表名称`
- 修改Update
- 删除Delete

#### DQL 数据查询语言 用来查询数据库中表的记录（数据

- 

#### DCL 数据控制语言 用来定义数据库访问权限和安全级别以创建用户

## JDBC

## Maven

## MyBatis

# 前端

## HTML+CSS

## JavaSript

## Ajax+Vue+ElementUI

# Web核心

## Tomcat+HTTP+Servlet

## Request+Response

## JSP

## Cooki+Session

## Filter+Listerer



