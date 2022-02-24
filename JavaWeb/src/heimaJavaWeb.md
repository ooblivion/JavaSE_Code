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

- 查询Retrieve
  
  - `show tables`
  - `use 数据库名`
  - `    show tables`
  - 查询表结构 `desc 表名称`
  
- 修改Update

  ```sql
  -- 修改表名
  ALTER TABLE 表名 RENAME TO 新的表名;
  -- 添加一列
  ALTER TABLE 表名 ADD 列名 数据类型;
  -- 修改数据类型
  ALTER TABLE 表名 MODIFY 列名 新数据类型;
  -- 修改列名和数据类型
  ALTER TABLE 表名 CHANGE 列名 新列名 新数据类型;
  -- 删除列
  ALTER TABLE 表名 DROP 列名;
  
  -- 修改表数据
  UPDATE 表名 SET 列名1=值1, 列名2=值2,...[WHERE 条件];
  
  ```

- 删除Delete

  ```sql
  -- 删除表
  DROP TABLE 表名;
  -- 删除表时判断是否存在
  DROP TABLE IF EXISTS 表名;
  ```

- 添加数据

  ```sql
  -- 给指定列添加数据
  INSERT INTO 表名(列名1, 列名2) VALUES(值1, 值2);
  -- 给全部列添加数据
  INSERT INTO 表名 VALUES(值1, 值2);
  --- 批量添加数据
  INSERT INTO 表名(列名1, 列名2) VALUES(值1, 值2), ...
  INSERT INTO 表名 VALUES(值1, 值2), ...
  ```

  

#### DQL 数据查询语言 用来查询数据库中表的记录（数据

```sql
SELECT

FROM

WHERE 

GROUP BY

HAVING 

ORDER BY

LIMIT
```

- 基础查询

  ```sql
  -- 查询多个字段
  SELECT 字段列表 FROM 表名;
  SELECT * FROM 表名; -- 查询所有数据
  
  -- 去除重复记录
  SELECT DISTINCT 字段列表 FROM 表名;
  
  -- 起别名
  AS: 
  ```

- 条件查询

- 分组查询

  ```sql
  SELECT 字段列表 FROM 表名 [WHERE 分组前的限定条件] GROUP BY 分组字段名 [HAVING 分组后条件过滤];
  
  ```

- 排序查询

- 分页查询

  ```sql
  SELECT 字段列表 FROM 表名 LIMIT 起始索引, 查询条目数;
  -- 从0开始算第一条数据，起始索引=(档前页码-1)*每页显示的条目数
  ```

- 聚合函数

  ```sql
  count
  max
  min 
  sum 
  avg
  
  select count(*) from table_name;
  ```

#### DCL 数据控制语言 用来定义数据库访问权限和安全级别以创建用户

---

## 数据库内部

### 约束

- 约束概念
  - 作用于表中列上的规则，用于限制加入表的数据。
  - 约束的存在保证了数据库中数据的正确性，有效性和完整性
- 约束分类（MySQL不支持检查约束
  - 非空约束：NOT NULL
  - 唯一约束：UNIQUE
  - 主键约束：PRIMARY KEY
  - 检查约束：CHECK
  - 默认约束：DEFAULT
  - 外键约束：FOREIGN KEY

外键

```sql
CREATE TABLE emp(
	id INT PRIMARY key auto_increment,
	ename VARCHAR(50) NOT NULL UNIQUE,
	joindate DATE NOT NULL,
	salary DOUBLE(7,2) NOT NULL,
	bonus DOUBLE(7,2) DEFAULT 0
)

INSERT INTO emp(id,ename,joindate,salary,bonus) VALUES
(1,'mike','1999-11-11',8000,2000),
('linda','1993-12-22',6000,2000),
('lindaa','1993-12-22',6000,2000)

SELECT * FROM emp;
SELECT * FROM dept;

-- 删除表
DROP TABLE IF EXISTS dept;
DROP TABLE IF EXISTS emp;

-- 从表，在从表内部创建外键，要先创建主表
CREATE TABLE emp(
	id INT PRIMARY KEY auto_increment,
	name VARCHAR(20),
	age INT,
	dep_id INT,
	-- 添加外键  dep_id 关联 dept表的id主键
	CONSTRAINT fk_emp_dept FOREIGN KEY (dep_id) REFERENCES dept(id)  
);

INSERT INTO emp(name, age, dep_id) VALUES
('mike', 20, 1),
('jack', 20, 1),
('linda', 22, 2),
('peter', 25, 1)

-- 创建表时候添加外键约束
-- [CONSTRAINT] [外键名称] FOREIGN KEY(外键列名) REFERENCES 主表(主表列名)

-- 建完表之后添加约束
-- ALTER TABLE 表名 ADD CONSTRAINT 外键名称 FOREIGN KEY(外键字段名称) REFERENCES 主表(主表列名)

-- 删除约束
-- ALTER TABLE 表名 DROP FOREIGN KEY 外键名称;
```

```sql
SELECT * FROM dept;

INSERT INTO dept (dep_name, addr) VALUES
('研发部', '广州'),
('销售部', '深圳')

-- 主表
CREATE TABLE dept(
	id INT PRIMARY KEY auto_increment,
	dep_name VARCHAR(10),
	addr VARCHAR(10)
)

```

### 数据库设计

业务系统中有什么数，数据用什么保存，表与表之间的关系 

- 数据库设计什么？
  - 有哪些表
  - 表里有哪些字段
  - 表和表之间是什么关系
- 表关系有哪几种
  - 一对一
  - 一对多
  - 多对多

#### 多对多

建立第三张中间表，中间表中至少包含两个外键，分别关联两方的主键

```sql
CREATE TABLE tb_order(
	id INT PRIMARY KEY auto_increment,
	payment DOUBLE(10,2),
	payment_type TINYINT,
	status TINYINT
);

CREATE TABLE tb_goods(
	id INT PRIMARY KEY auto_increment,
	title VARCHAR(100),
	price DOUBLE(10,2)
);

-- 中间表还可以记录其他业务字段
CREATE TABLE tb_order_goods(
	id INT PRIMARY KEY auto_increment,
	order_id INT,
	goods_id INT,
	count INT
-- 	CONSTRAINT fk_order_id FOREIGN KEY (order_id) REFERENCES order(id)  
-- 	CONSTRAINT fk_goods_id FOREIGN KEY (goods_id) REFERENCES goods(id)  
)

SELECT * FROM tb_order;
SELECT * FROM tb_goods;
SELECT * FROM tb_order_goods;

DROP TABLE IF EXISTS tb_order, tb_goods, tb_order_goods;

-- 添加外键
ALTER TABLE tb_order_goods ADD CONSTRAINT fk_order_id FOREIGN KEY(order_id) REFERENCES tb_order(id);
ALTER TABLE tb_order_goods ADD CONSTRAINT fk_goods_id FOREIGN KEY(goods_id) REFERENCES tb_goods(id);
```

#### 一对一

- 如用户和用户详情
- 一对一关系用于多表拆分，将一个实体中经常使用的字段还在一张表，不经常使用的字段放在另一张表，用于提示查询性能
- 实现方式：在任意一方加入外键，关联另一方的主键，并且设置外键为UNIQUE

#### 一对多

- 在多的一方建立外键，关联另一方的主键

### 多表查询

```sql
# 多表查询 案例
DROP TABLE IF EXISTS emp;
DROP TABLE IF EXISTS  dept;

# 创建部门表
CREATE TABLE dept(
	did INT PRIMARY KEY AUTO_INCREMENT,
	dname VARCHAR(20)
);

# 创建员工表
CREATE TABLE emp(
	id INT PRIMARY KEY AUTO_INCREMENT,
	NAME VARCHAR(10),
	gender CHAR(1),
	salary DOUBLE, 
	join_date DATE,
	dep_id INT,
	FOREIGN KEY (dep_id) REFERENCES dept(did)
);

# 添加部门数据
INSERT INTO dept (dname) VALUES ('研发部'),('市场部'),('财务部'),('销售部')

# 添加员工数据

INSERT INTO emp(NAME, gender, salary, join_date, dep_id) VALUES
('孙悟空','男',7200,'2013-02-01',1),
('猪八戒','男',2200,'2010-02-01',2),
('唐僧','男',3200,'2019-02-01',2),
('白骨精','女',1200,'2016-02-01',3),
('小龙女','女',5200,'2013-02-01',1),
('小白龙','男',8200,'2014-02-01',null)

# 连接查询
SELECT * FROM emp, dept
# 笛卡尔积 6*4=24
# 消除无效数据
WHERE emp.dep_id = dept.did; 
```

- 连接查询

  - 内连接，查询两表交集

    - 隐式内连接

      ```sql
      SELECT * FROM emp, dept WHERE emp.dep_id = dept.did; 
      
      -- 查询emp的name，gender，dept表的dname
      SELECT emp.name, emp.gender, dept.name 
      FROM emp, dept where emp.dep_id = dept.did;
      -- 给表起别名
      SELECT t1.name, t1.gender, t2.name 
      FROM emp t1, dept t2 where t1.dep_id = t2.did;
      ```

    - 显示内连接，可以查询指定字段表

      ```sql
      SELECT 字段列表 FROM 表1 [INNER] JOIN 表2 ON 条件;
      SELECT * FROM emp INNER JOIN dept ON emp.dep_id = dept.did; 
      
      SELECT t1.name, t1.gender, t2.name 
      FROM emp t1 INNER 
      JOIN dept t2 
      ON t1.dep_id = t2.did;
      
      ```

  - 外连接

    ```sql
    SELECT * FROM emp LEFT JOIN [OUTER] dept ON emp.dep_id = dept.did;
    SELECT * FROM emp RIGHT JOIN [OUTER] dept ON emp.dep_id = dept.did;
    ```

- 子查询

  - 单行单列：作为条件值 使用 = != > < 判读

    ```sql
    SELECT 字段列表 FROM 表 WHERE 字段名 = (子查询);
    ```

  - 多行单列：作为条件值 使用in关键字进行判断

    ```sql
    SELECT 字段列表 FROM 表 WHERE 字段名 in (子查询);
    ```

  - 多行多列：作为虚拟表 

    ```sql
    SELECT 字段列表 FROM (子查询) WHERE 条件;
    ```


### 事物

事物是SQL语句执行的最小单位



## JDBC

JDBC是用Java语言操作关系型数据库的一套API，去MySQL官网下载connection/j -> jar包

### JDBC快速入门

```sql
-- 菜鸟教程
CREATE TABLE `websites` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` char(20) NOT NULL DEFAULT '' COMMENT '站点名称',
  `url` varchar(255) NOT NULL DEFAULT '',
  `alexa` int(11) NOT NULL DEFAULT '0' COMMENT 'Alexa 排名',
  `country` char(10) NOT NULL DEFAULT '' COMMENT '国家',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

INSERT INTO `websites` VALUES ('1', 'Google', 'https://www.google.cm/', '1', 'USA'), ('2', '淘宝', 'https://www.taobao.com/', '13', 'CN'), ('3', '菜鸟教程', 'http://www.runoob.com', '5892', ''), ('4', '微博', 'http://weibo.com/', '20', 'CN'), ('5', 'Facebook', 'https://www.facebook.com/', '3', 'USA');
```

```java
//菜鸟教程
public class MySQLDemo {

//    MySQL 8.0 以下版本 - JDBC 驱动名及数据库 URL
//    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
//    static final String DB_URL = "jdbc:mysql://localhost:3306/RUNOOB";

    // MySQL 8.0 以上版本 - JDBC 驱动名及数据库 URL
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/db_study?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";


    // 数据库的用户名与密码，需要根据自己的设置
    static final String USER = "root";
    static final String PASS = "wwtooblivion";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try{
            // 注册 JDBC 驱动
            Class.forName(JDBC_DRIVER);

            // 打开链接
            System.out.println("连接数据库...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            // 执行查询
            System.out.println(" 实例化Statement对象...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT id, name, url FROM websites";
            ResultSet rs = stmt.executeQuery(sql);

            // 展开结果集数据库
            while(rs.next()){
                // 通过字段检索
                int id  = rs.getInt("id");
                String name = rs.getString("name");
                String url = rs.getString("url");

                // 输出数据
                System.out.print("ID: " + id);
                System.out.print(", 站点名称: " + name);
                System.out.print(", 站点 URL: " + url);
                System.out.print("\n");
            }
            // 完成后关闭
            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException se){
            // 处理 JDBC 错误
            se.printStackTrace();
        }catch(Exception e){
            // 处理 Class.forName 错误
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
```

```java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
//哈哈，这都给我连上了。置顶
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
        System.out.println(count);//1

        //7. 释放资源
        stmt.close();
        conn.close();

    }
}
```

### JDBC API 详解

#### **DriverManager** 注册驱动，获取数据库连接

- ```java
  Class.forName("com.mysql.jdbc.driver");
  
  Connection conn = DriverManager.getConnection(url, username, password);
  ```

#### **Connection**

- 获取执行SQL的对象

  - 普通执行对象：`Statement createStatement`
  - 预编译SQL的执行SQL对象，防止SQL注入：`PreparedStatement prepareStatement(sql)`
  - 执行存储过程的对象：`CallableStatement prepareCall(sql)`

- ***事物管理***

  - MySQL事物管理（MySQL默认自动提交事物
    - 开启事物：BEGIN; /START TRANSACTION
    - 提交事物：COMMIT
    - 回滚事物：ROLLBACK
  - JDBC事物管理：Connection中定义了三个对应的方法
    - 开启 setAutoCommit(boolean autoCommit); //true为自动提交事物
    - 提交 commit()
    - 回滚 rollback()

- 代码示例

  ```java
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
  ```

#### **Statement**

- 执行SQL语句
  - `int executeUpdate(sql)` 
    - 执行DML，DDL语句
    - 返回值为DML语句影响的行数，DDL语句执行后也可能返回0
  - `ResultSet executeQuery(sql)` 
    - 执行DQL语句
    - 返回值ResultSet结果对象

####  **ResultSet**

- 封装了DQL查询语句的结果

  - `ResultSet stmt.exeuteQuery(sql)`

    - 执行DQL语句，返回ResultSet对象

  - 获取查询结果

    - `boolean next()` 
      - 将光标从当前位置向前移动一行，判断当前行是否为有效行
    - `xxx getXxx(参数)` `int getInt(1)` `String getString("name")`  
      - 参数为int，代表列的编号从1开始（不是0）；参数为String，列的名称

  - 代码示例

    ```java
    public class ResultSetDemo {
        public static void main(String[] args) throws Exception{
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
    ```

- ResultSet案例：查询emp数据表，封装为employee对象，并且存户到ArrayList集合中

  ```java
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
  ```

#### **PreparedStatement** 

- 预编译可以解决SQL注入的问题

- 什么是SQL注入：通过操作输入来修改事先预定好的语句，用以达到执行代码对服务器进行攻击的方法

- 先创建用户表

  ```sql
  -- 删除tb_user表
  DROP TABLE IF EXISTS tb_goods;
  
  -- 创建tb_user表
  CREATE TABLE tb_user(
  	id INT,
  	username VARCHAR(20),
  	password VARCHAR(32)
  );
  
  -- 添加用户数据
  INSERT INTO tb_user VALUES
  (1,'mike','123'),
  (2,'lineda','234');
  
  SELECT * FROM tb_user;
  ```

- SQL注入（拼字符串改变了sql语义

  ```java
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
  
  //        String name ="mike";
  //        String pwd = "123";
          String name = "xxxxx";
          String pwd = "' or '1' = '1";
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
  ```

- 防止SQL注入

  ```java
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
  ```

- PrepareStatement原理

  - 好处
    - 预编译SQL，性能更高
    - 防止SQL注入，将敏感字符进行转义
  - 预编译功能开启
    - `useServicePrepStmts=true`
    - `String url = "jdbc:mysql://127.0.0.1:3306/db_study?useSSL=false&useServicePrepStmts=true";`
  - 配置MySQL执行日志（重启mysql后生效）
  - 原理
    - 在获取PreparedStatement对象时，将sql语句发送给MySQL服务器进行检查，编译（这步比较耗时）
    - 执行时不用再检查这些步骤，速度更快
    - 如果sql模板一样，则只需要进行一次检查（一般是要先检查，再编译，再执行）

### 数据库连接池



## Maven

## MyBatis

### MyBatis概述

- 什么是MyBatis？
  - MyBatis 是一个开源、轻量级的数据**持久化框架**，是 JDBC 和 Hibernate 的替代方案。MyBatis 内部封装了 JDBC，简化了加载驱动、创建连接、创建 statement 等繁杂的过程，开发者只需要关注 SQL 语句本身（用于简化JDBC开发）。
- 持久层
  - 负责将数据保存到数据库那一层的代码
  - JavaEE三次架构：表现层，业务层，**持久层**
- 框架
  - 框架就是一个半成品软件，是一套可重用的，通用的，软件基础代码模型
  - 在框架的基础架构之上构建软件编写更加高效，规范，通用，可拓展

|               JDBC缺点               | MyBatis优化              |
| :----------------------------------: | ------------------------ |
|      硬编码：注册驱动，SQL语句       | 将字符串信息写入配置文件 |
| 操作繁琐：手动设置参数，手动封装结果 | 自动完成                 |

### MyBatis快速入门

- 查询user表中的所有数据
  1. 创建user表，添加数据
  2. 创建模块，导入坐标
  3. 编写MyBatis核心配置文件 -> 替换连接信息 解决硬编码问题
  4. 编写SQL映射文件 -> 统一管理SQL语句，解决硬编码问题
  5. 编码
     - 定义POJO类
     - 加载核心配置文件，获取SqlSessionFactory对象
     - 获取SqlSession对象，执行SQL语句（Statement
     - 释放资源

1. 先创建一个表

```sql
DROP TABLE IF EXISTS tb_user;
CREATE TABLE tb_user(
	id INT PRIMARY KEY AUTO_INCREMENT,
	username VARCHAR(20),
	password VARCHAR(20),
	gender CHAR(1),
	addr VARCHAR(30)
);
INSERT INTO tb_user VALUES 
(1, 'zhangsan', '123', '男', '北京'),
(2, '李四', '234', '女', '天津'),
(3, 'wangwu', '222', '男', '上海')
```

2. 在pom.xml中添加依赖，mysql的驱动和mybatis

```xml
<dependencies>
     <dependency>
        <groupId>org.mybatis</groupId>
        <artifactId>mybatis</artifactId>
        <version>3.3.0</version>
    </dependency>
    <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>5.1.25</version>
     </dependency>
  </dependencies>
```

添加logback.xml到main-resources中

```xml
<?xml version="1.0" encoding="UTF-8"?>
<configuration>
    <!-- CONSOLE : 表示当前的日志是可以输出到控制台的 -->
    <appender name="Console" class="ch.qos.logback.core.ConsoleAppender">
        <encoder>
            <pattern>[%level] %blue(%d{HH:mm:ss.SSS}) %cyan([%thread]) %boldGreen(%logger{15}) - %msg %n</pattern>
        </encoder>
    </appender>

    <logger nam="com.itheima" level="DEBUG" additivity="false">
        <appender-ref ref="Console"/>
    </logger>
</configuration>
```

3. 编写MyBatis核心配置文件 -> 替换连接信息 解决硬编码问题 mybatis-config.xml

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>
    <environments default="development">
        <environment id="development">
            <transactionManager type="JDBC"/>
            <dataSource type="POOLED">
                <property name="driver" value="com.mysql.cj.jdbc.Driver"/>
                <property name="url" value="jdbc:mysql://127.0.0.1:3306/db_study?useSSL=false"/>
                <property name="username" value="root"/>
                <property name="password" value="wwtooblivion"/>
            </dataSource>
        </environment>
    </environments>
    <mappers>
        <!-- 加载SQL的映射文件，等会来修改-->
        <mapper resource="UserMapper.xml"/>
    </mappers>
</configuration>
```

- 编写SQL映射文件 -> 统一管理SQL语句，解决硬编码问题 UserMapper.xml

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">

<!-- namespace 名称空间 -->
<!--<mapper namespace="org.mybatis.example.BlogMapper">-->
<mapper namespace="test">
    <select id="selectAll" resultType="com.itheima.pojo.User"><!-- 返回结果的类型 -->
        select * from tb_user;
    </select>
<!--    <insert id=""-->
<!--    <update id=""-->
<!--    <delete id=""-->
</mapper>
```

为什么报错了呢😭😭😭😭😭😭



### 解决SQL语句警告提示

### Mapper代理开发

### MyBatis核心配置文件

### MyBatis案例

### 

### 

# 前端

## HTML+CSS

### HTML

- HTML框架

  ```html
  <!DOCTYPE html>
  <html lang="en">
  <head>
      <meta charset="UTF-8">
      <title>Title</title>
  </head>
  <body>    
  <!-- code -->
      
  <!-- 
  code
  -->
  </body>
  </html>
  ```

- HTML基础标签

  ```html
  <h1></h1>
  <font face = "楷体" size = "5" color = "#ffc0cb"></font>
  <b></b>
  <i></i>
  <u></u>
  <center></center>
  <p>
     this is a paragraph 
  </p>
  <br>
  <hr>
  ```

- 特殊转义字符

  ```html
  &lt; <!-- < -->
  &gt; <!-- > -->
  &amp; <!-- & -->
  &quto; <!-- " -->
  &reg; <!-- r -->
  &copy; <!-- c -->
  &trade; <!-- tm -->
  &nbsp; <!-- space -->
  ```

- 图片，音频，视频（注意相对路径

  ```html
  <img src="url" width="xxx" height="xxx"> <!-- src heigh width 默认单位px or %-->
  <audio src="url" controls="controls"></audio> <!-- src controls MP3/WAV/OGG -->
  <video src="url" controls width="500" height="300"></video> <!-- src controls MP4/WebM/OGG-->
  ```

- 超链接

  ```html
  <a href="url" target="_blank"></a> <!--self blank parent top>
  ```

- 列表标签

  ```html
  <ol type="A">
      <li>aaa</li>
      <li>bbb</li>
      <li>ccc</li>
  </ol>
  
  <ul type=cirle>
      <li>aaa</li>
      <li>bbb</li>
      <li>ccc</li>
  </ul>
  ```

- 表格标签

  ```html
  <table width="50%" border="1" cellspacing="0">
      <tr align="center">
          <th>number</th>
          <th>type</th>
          <th>count</th>
      </tr>
      <tr>
          <td>01</td>
          <td>type1</td>
          <td>100</td>
      </tr>
  </table>
  <!--
  table 表格 width 表格的宽度 border 表格边框宽度 cellspacing 单元格之间的空白
  td 单元格 rowspan 单元格可跨行数 colspan单元格可跨列数
  th 表头单元格
  tr 行 align 定义表格行的内容对其方式
  
  -->
  
  <table width="80%" border="1" cellspacing="0">
  
      <tr align="center">
          <th colspan="2"></th>
          <th>星期一</th>
          <th>星期二</th>
          <th>星期三</th>
          <th>星期四</th>
          <th>星期五</th>
      </tr>
  
      <tr align="center">
          <td rowspan="4">上午</td>
          <td>早自习</td>
          <td>英语</td>
          <td>语文</td>
          <td>英语</td>
          <td>语文</td>
          <td>英语</td>
      </tr>
  
      <tr align="center">
          <td>第一节</td>
          <td>第一节</td>
          <td>第一节</td>
          <td>第一节</td>
          <td>第一节</td>
          <td>第一节</td>
      </tr>
  
      <tr align="center">
          <td>第一节</td>
          <td>第一节</td>
          <td>第一节</td>
          <td>第一节</td>
          <td>第一节</td>
          <td>第一节</td>
      </tr>
  
      <tr align="center">
          <td>第一节</td>
          <td>第一节</td>
          <td>第一节</td>
          <td>第一节</td>
          <td>第一节</td>
          <td>第一节</td>
      </tr>
  
      <tr align="center">
          <td colspan="7">午休</td>
      </tr>
  
      <tr align="center">
          <td rowspan="3">下午</td>
          <td>第四节</td>
          <td>生物</td>
          <td>生物</td>
          <td>生物</td>
          <td>生物</td>
          <td>生物</td>
      </tr>
  
      <tr align="center">
          <td>第五节</td>
          <td>数学</td>
          <td>数学</td>
          <td>数学</td>
          <td>数学</td>
          <td>数学</td>
      </tr>
  
      <tr align="center">
          <td>第六节</td>
          <td>英语</td>
          <td>英语</td>
          <td>英语</td>
          <td>英语</td>
          <td>英语</td>
      </tr>
  </table>
  ```

- 布局标签

  ```html
  <div></div>
  <!-- 定义html文档中的一个区域部分，经常与css一起使用，用来布局网页 -->
  <span></span>
  <!-- 用于组合行内元素 -->
  ```

- 表单标签

  ```html
  <form></form> 定义表单
  <input> 定义表单项，通过type属性控制输入形式
  <label></label> 为表单项定义标注
  <select></select> 定义下拉列表
  <option></option> 定义下拉列表的列表项
  <textarea></textarea> 定义文本区域
  ```

  - form 定义表单
    - action：规定提交表单时向何处发送数据，URL
      - 表单数据项想要被提交，则必须指定其name属性
    - method：规定用于发送表单数据的方式
      - get：浏览器会将数据附在表单actcion URL之后，大小有限制4kb，默认为get
      - post：浏览器会将数据放在http请求消息体中，大小无限制

  ```html
  <form action="#" method="get">
      <input type="text" name="username">
      <input type="submit">
  </form>
  ```

- 表单项标签

  ```html
  <input>
  <selet></selet>
  <testarea></testarea>
  
  <form action="#" method="post">
      <input type="hidden" name="id" value="123">
  
      <label for="username">用户名：</label>
      <input type="text" name="username" id="username"><br>
  
      <label for="password">密码：</label>
      <input type="password" name="password" id="password"><br>
  
      性别：
      <input type="radio" name="gender" value="1" id="male"> <label for="male">男</label>
      <input type="radio" name="gender" value="2" id="female"> <label for="female">女</label>
      <br>
  
      爱好：
      <input type="checkbox" name="hobby" value="1">游戏
      <input type="checkbox" name="hobby" value="2">电影
      <input type="checkbox" name="hobby" value="3">旅游
      <input type="checkbox" name="hobby" value="4">发呆
      <br>
  
      头像：
      <input type="file"><br>
  
      城市：
      <select name="city">
          <option>北京</option>
          <option>上海</option>
          <option>广州</option>
      </select>
  
      个人描述：
      <textarea cols="20" rows="5" name="describe"></textarea>
      <br>
  
      <br>
      <input type="submit" value="免费注册">
      <input type="reset" value="重置">
      <input type="button" value="一个按钮，以后结合js使用">
  
  </form>
  ```

  - input：表单项，通过type属性控制输入
    - type
      - text：默认值，定义单行输入字段
      - password：定义密码字段
      - radio：定义单选按钮
      - checkbox：定义复选框，可以选择多个 
      - file：上传文件到服务器
      - hidden：定义隐藏的输入字段
      - submit：定义提交按钮，将表单数据发送到服务器
      - reset：定义重置按钮，清除表单中所有数据
      - button：定义可点击按钮
  - select：定义下拉列表，`<option>定义列表项`
  - textarea：文本域

- 

### CSS

#### CSS简介

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <style>
        div{
            color: aquamarine;
        }
    </style>
</head>
<body>

<div>Hello CSS!</div>

</body>
</html>
```

#### CSS导入方式

- 内嵌样式 css和html耦合，不利于复用和修改

  ```html
  <div style="color: red">
      Hello CSS!
  </div>
  ```

- 内部样式，放在head内部

  ```html
  <style type="text/css">
      div{
          color: red;
      }
  </style>
  ```

- 外部样式

  ```html
  <link rel="stylesheet" href="demo.css">
  
  <!-- demo.css -->
  div{
  	color: red;
  }
  ```

#### CSS选择器

- 概念：选取需要设置样式的元素（标签）

- 分类

  - 元素选择器

    ```css
    元素名称{color: red}
    ```

  - id选择器

    ```css
    #id属性值{color: red;}
    ```

  - 类选择器

    ```css
    .class属性值{color: red;}
    ```

#### CSS属性

```css
body{
    background-color:yellow;
}
h1{
    background-color:#00ff00;
}
p{
    bakground-color:rgb(255,0,255);
}
```

## JavaSript

- 概述：是一门跨平台，面向对象的脚本语言，用来控制网页行为的，使得网页可交互。

### JS引入方式

- 内部脚本

  ```html
  <script>
      alert("hello js!");
  </script>
  ```

- 外部脚本

  ```js
  alert("hello js!");
  ```

  ```html
  <script src="../js/demo.js"></script>
  ```

一般把脚本放在body底部，可改善显示速度，因为脚本的执行会拖慢显示

### JS语法

#### 书写语法

- 每行结尾分号可有可无

- 大括号表示代码块

  ```javascript
  if(count == 3){
      alert(count);//弹出3
  }
  ```

#### 输出语句

- `windou.alert("hello")` 写入警告框
- `document.write("hello")` 写入html输出
- `console.log("hello")` 写入控制台

#### 变量

- `var test = 20; test = "MIke"`
- JS是弱类型语言，变量可以存放数字也可以存放字符串
- `let var = 30;` let修饰的变量只在代码块中有效，而且不能重名
- `const` 类似java中的final 

#### 数据类型

- `number` 整数，小数，NaN-not a number
- `string`
- `boolean`
- `null`
- `undefined`
- 获取数据类型：`alert(typeof age);`

#### 运算符

- `==`：==js中比较运算符首先会进行类型转换，然后再比较值是否相同

- `===`：===首先会进行类型判断，类型不一样直接返回false

  ```js
  var age1 = 20;
  var age2 = "20"
  alert(age1 == age2);//true
  alert(age1 === age2);//false
  ```

- 类型转换

  - 其他类型转为number

    - stirng：按照字面值转换为数字，如果字面值不是数字，直接转换为NaN

    - boolean：true转换为1，false转换为0

      ```js
      var flag = +true;
      alert(flag);//1
      ```

  - 其他类型转换boolean

    - number：0和NaN转为false，其他数字转为true
    - string：空字符转换为false，其他字符为true
    - null/undefined：false

#### 流程控制语句

- if
- switch
- for
- while
- do...while

#### 函数

- 定义方式1

  ```js
  function add(i, j){
      return a+b;
  }
  let result = add(1,2);
  alert(result)
  ```
  - 形式参数不需要数据类型
  - 返回值也不需要定义类型

- 定义方式2

  ```js
  var add = function(a,b){
      return a+b;
  }
  let result = add(1,2);
  alert(result);//3
  
  let result = add(1,2,3);
  alert(result);//3
  ```

  - JS中，函数调用可以传入任意个数参数，多的被忽略，少的算作NaN

### JS常用对象

#### JS基础对象

- Array

  - ```js
    var arr = new Array(1,2,3);
    var arr = [1,2,3];
    //arr[0] = 1;
    //arr[3] undefine
    
    arr[5] = "hello"
    alert(arr);//1,2,3,,hello
    
    for(let i = 0; i < arr.length; i++){
        alert(arr[i]);
    }
    
    //添加元素
    arr.push(10);//返回数组元素个数
    alert(arr);//1,2,3,,hello,10
    
    //删除元素，从0开始，删除1个元素
    arr.splice(0,1);
    alert(arr);//2,3,,hello,10
    ```

  - JS数组类似Java集合，长度可变

  - Arrays对象属性

    - constructor
    - length
    - prototype

  - 方法

- Boolean

- Date

- Math

- Number

- String

  - ```js
    var str = new String("hello");
    var str = "hello";
    ```

  - 属性

    - length

  - 方法

    - charAt() 返回在指定位置的字符
    - indexOf() 检索字符串所在位置
    - trim() 去除两端空白字符

- RegExp

- Global

- 自定义对象

  - ```js
    var Obj_name = {
        属性名称1: 属性值1,
        属性名称2: 属性值2,
        ...
        函数名称:function(形参列表){}
    ...
    };
    
    <script>
        var Person = {
            name : "mike",
            age : 23,
            eat:function(){
                alert("i can eat");
            }
        };
    
        alert(person.name);
        Person.eat();
    </script>
    ```

#### Browser对象

- Window 浏览器窗口对象

  - 方法

    - alert()

    - confirm() 点击确定按钮会返回true，点击取消会返回false

    - setInterval() 按照指定周期来调用函数或计算表达式，循环执行

    - setTimeout() 在指定毫秒后调用函数或计算表达式，在对应的事件之后只执行一次

      ```js
      setTimeout(funtion (){
      	alert("haha")
      }, 3000);//3s后弹个haha
      ```

  - 案例：开关灯

    ```js
    
    ```

    

- Navigator

- Screen

- History

- Location

#### HTML DOM对象

- Document
- Anchor

### BOM

### DOM

### 事件监听



### 正则表达式

```javascript
var reg = /^\w{6,12}$S/;
var reg = new RegExp(/^\w{6,12}$S/)
```

- 语法

  - `^` 表示开始

  - `$` 表示结束

  - `[]` 代表某个范围内的单个字符，比如`[0-9]`

  - `.` 代表任意单个字符，除了换行和行结束符

  - `\w` 代表单词字符：字母，数字，下划线，相当于`[A-Za-z0-9_]`

  - `\d` 代表数字字符：相当于`[0-9]`

  - `+` 至少一个

  - `*` 0或多个

  - `?` 0或1个

  - {x}：x个

  - {m,}：至少m个

  - {m,n}：最少m个，最多n个，个数范围

    ```javascript
    var reg = /^\w{6,12}$/;
    var str = "abcccc"
    var flag = reg.test(str);
    alert(falg);//返回true
    ```

    

- 邮箱的匹配规则

  - ``

## 

# Web核心

- 什么是JavaWeb
  - Web是广域网，也叫万维网，是能通过浏览器访问呢的网站
  - 用Java的技术来解决相关web互联网领域的技术栈
- JavaWeb技术栈
  - B/S架构：Browser/Server，浏览器/服务器架构模式，客户端只需要浏览器，应用程序和逻辑数据都放在服务器端。浏览器只需要请求服务器，获取Web资源，服务器把Web资源发送给浏览器即可。（请求和响应）
  - 好处：易于维护升级，服务端升级后，客户端无需任何部署就可以使用到最新的版本
  - 静态资源：HTML/CSS/JS，图片等，负责页面展现
  - 动态资源：***Servlet*** JSP ，负责逻辑处理
  - 数据库：负责存储数据
  - ***HTTP协议***：定义通信规则
  - Web服务器***Tomcat***：负责解析HTTP协议，解析请求数据，并发送响应数据

## Tomcat+HTTP+Servlet

### HTTP

#### HTTP简介

- HTTP协议特点
  - 基于TCP协议，面向连接，安全
  - 基于请求-响应模型，一次请求对应一次响应
  - HTTP协议是**无状态**的协议，对于事物处理没有记忆能力，每次请求-响应都是独立的
    - 缺点：多次请之间无法共享数据，**Java中会使用会话技术（Cookie/Session）来解决这个问题**
    - 优点：速度块

#### 请求数据格式

- 请求行：请求数据的第一行，其中GET表示请求的方式，/表示请求的路径，HTTP/1.1表示协议的版本

- 请求头：第二行开始，格式为key:value形式

  - 常见的请求头
    - **Host**：表示请求的主机名
    - **User-Agent**：浏览器版本，例如Chrome浏览器的标识类似Mozilla/5.0...Chrome/79，IE浏览器的标识类似Mozilla/5.0(Windows NT ...) like Gecko，一般用于浏览器的兼容处理
    - **Accept**：标识浏览器能接收的资源类型，比如`text/*`，`image/*`，或者*/*表示所有
    - **Accept-Language**：表示浏览器偏好的语言，服务器可以根据这个返回不同语言的网页
    - **Accept-Encoding**：表示可以支持的压缩类型，例如gzip，deflate，Servlet能够向支持gzip的浏览器返回经gzip编码的HTML页面。许多情形下这可以减少5到10倍的下载时间
    - **Accept-Charset**：浏览器可接受的字符集
    - **Authorization**：授权信息，通常出现在对服务器发送的WWW-Authenticate头的应答中
    - **Connection**：表示是否需要持久连接。如果Servlet看到这里的值为“Keep-Alive”，或者看到请求使用的是HTTP 1.1（HTTP 1.1默认进行持久连接），它就可以利用持久连接的优点，当页面包含多个元素时（例如Applet，图片），显著地减少下载所需要的时间。要实现这一点，Servlet需要在应答中发送一个Content-Length头，最简单的实现方法是：先把内容写入ByteArrayOutputStream，然后在正式写出内容之前计算它的大小
    - **Content-Length**：表示请求消息正文的长度
    - **Cookie**：这是最重要的请求头信息之一
    - **From**：请求发送者的email地址，由一些特殊的Web客户程序使用，浏览器不会用到它
    - **Host**：初始URL中的主机和端口
    - **If-Modified-Since**：只有当所请求的内容在指定的日期之后又经过修改才返回它，否则返回304“Not Modified”应答
    - **Pragma**：指定“no-cache”值表示服务器必须返回一个刷新后的文档，即使它是代理服务器而且已经有了页面的本地拷贝
    - **Referer**：包含一个URL，用户从该URL代表的页面出发访问当前请求的页面
    - **User-Agent**：浏览器类型，如果Servlet返回的内容与浏览器类型有关则该值非常有用
    - **UA-Pixels****，UA-Color，UA-OS，UA-CPU**：由某些版本的IE浏览器所发送的非标准的请求头，表示屏幕大小、颜色深度、操作系统和CPU类型

- 请求体：POST请求的最后一部分，存放请求参数

- 以百度的http为示例

  ```http
  GET / HTTP/1.1
  Host: www.baidu.com
  Connection: keep-alive
  sec-ch-ua: " Not A;Brand";v="99", "Chromium";v="98", "Google Chrome";v="98"
  sec-ch-ua-mobile: ?0
  sec-ch-ua-platform: "Windows"
  Upgrade-Insecure-Requests: 1
  User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/98.0.4758.82 Safari/537.36
  Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9
  Sec-Fetch-Site: none
  Sec-Fetch-Mode: navigate
  Sec-Fetch-User: ?1
  Sec-Fetch-Dest: document
  Accept-Encoding: gzip, deflate, br
  Accept-Language: zh-CN,zh;q=0.9,en-US;q=0.8,en;q=0.7,ja-JP;q=0.6,ja;q=0.5
  Cookie: BIDUPSID=B31CCC99431B123E381179771AE63F5D; PSTM=1607960531; __yjs_duid=1_83a0f3d55e8eee05518aa34352a572081619616586930; H_WISE_SIDS=107313_110085_127969_131861_168388_176398_176554_177370_178384_178530_178626_179347_179467_179623_181106_181133_181135_181487_181588_181713_181872_182000_182240_182273_182529_183035_183236_183328_183346_183536_183581_183611_183975_184042_184245_184320_184560_184736_184789_184794_184811_184893_185029_185251_185288_185300_185498_185518_185651_185747_185903_186014_186314_186317_186412_186539_186595_186660_186661_186716_186841_186895_187038_187195_187201_187214_187282_187293_187325_187390_187417_187432_187450_187662_8000090_8000101_8000130_8000139_8000143_8000150_8000162_8000175_8000186_8000189; BDUSS=FVNV1dWdHl3OWNNWmFYeGx6dFh1cjRJVUpXTlZDUTl4OVhIam10Mi1abnAzbmRoRVFBQUFBJCQAAAAAAAAAAAEAAAC1HgiPtt6439Gn1PwAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAOlRUGHpUVBhT; BDUSS_BFESS=FVNV1dWdHl3OWNNWmFYeGx6dFh1cjRJVUpXTlZDUTl4OVhIam10Mi1abnAzbmRoRVFBQUFBJCQAAAAAAAAAAAEAAAC1HgiPtt6439Gn1PwAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAOlRUGHpUVBhT; BD_UPN=12314753; BAIDUID=D7AF3A23C79717E82B14EAF89ACDCDAF:FG=1; BDORZ=FFFB88E999055A3F8A630C64834BD6D0; BAIDUID_BFESS=D7AF3A23C79717E82B14EAF89ACDCDAF:FG=1; delPer=0; BD_CK_SAM=1; PSINO=5; ab_sr=1.0.1_M2Y3MWZjODIyMTllMTU3YjQ3MjYyMjcyNzU5YzIyM2E1YWI0YzY2NmRiYTRlMzljMjhhZWExMjg1OWRkOTg3YzgzMTYzNDlkMzdhMTBiNmY4ODU1NjAwOTMxOTVkMDBiYzg0ZjU0YWJiMDA5ZDM5ZTMyODYxNWNhMGFmNGJjMWZkNjVkZDY0OWYwNDkxNjJmMmVmMWQ5ZjI3MDIyNDgzZA==; BDRCVFR[NUOtsRvVoHc]=mk3SLVN4HKm; BD_HOME=1; H_PS_PSSID=; sugstore=1; BA_HECTOR=ak85ag2h2h00a42hp81h1bpi70q
  ```

- HTTP的请求方式有7中，现在只知道GET和POST

- GET请求和POST请求的区别

  - GET请求：请求参数在请求行中，没有请求体，而且请求参数大小有限制
  - POST请求：请求参数在请求体中，请求参数大小没有限制

#### 响应数据格式

- 响应行：响应数据第一行，其中HTTP/1.1表示协议版本，200表示响应状态码，OK表示状态码描述

- 响应头：第二行开始，格式为key:value形式

- 响应体：最后一部分，存放响应数据

- 还是以百度的响应树为例

  ```http
  HTTP/1.1 200 OK
  Bdpagetype: 2
  Bdqid: 0xc49da745000792f4
  Cache-Control: private
  Connection: keep-alive
  Content-Encoding: gzip
  Content-Type: text/html;charset=utf-8
  Date: Wed, 23 Feb 2022 07:46:20 GMT
  Expires: Wed, 23 Feb 2022 07:46:20 GMT
  Server: BWS/1.1
  Set-Cookie: BDSVRTM=402; path=/
  Set-Cookie: BD_HOME=1; path=/
  Set-Cookie: H_PS_PSSID=35837_35104_31254_35768_35489_35865_34584_35490_35246_35949_35954_35319_26350_35882_35879_22157; path=/; domain=.baidu.com
  Strict-Transport-Security: max-age=172800
  Traceid: 1645602380075325799414167663917572526836
  X-Frame-Options: sameorigin
  X-Ua-Compatible: IE=Edge,chrome=1
  Transfer-Encoding: chunked
  ```

- 响应状态码的几种类型
  - 1：响应中，临时状态码，表示请求已经接受，告诉客户端应该继续请求或者如果他已经完成则忽略它
  - 2：成功，表示响应已经被成功接收，处理完成
    - 200 OK 客户端**处理成功**
  - 3：重定向，重定向到其他地方，让客户端再发起一个请求以完成整个处理
    - 302 Found 指示所请求的资源已移动到Location响应头给定的URL，浏览器会自动重新返回到这个页面
    - 304 Not Modified 告诉客户端上次资源请求后服务端并未更改，直接用本地缓存中的数据
  - 4：客户端错误，处理发生错误，责任在客户端，如：客户端请求一个不存在的资源，客户端没有被授权，禁止访问等。
    - 400 Bad Request 客户端请求**语法错误**，不能被服务器理解
    - 403 Forbidden 服务器收到请求但**拒绝提供服务**，比如没有权限访问相关资源
    - 404 Not Found **请求资源不存在**，一般是URL输入有误或网站资源被删除了
    - 428 Precondition Require **服务器要有条件的请求**是，告诉客户端想要访问该资源必须携带特定的请求头
  - 5：服务端错误，处理发送错误，责任在服务端，如：服务端抛出异常，路由错误，HTTP版本不支持等
- 常见的HTTP响应头
  - **Content-Type**：表示响应内容的类型，例如text/html，image/jpeg
  - **Content-Length**：表示响应内容的长度（字节数）
  - **Content-Encoding**：表示该响应压缩算法，例如gzip
  - **Cache-Control**：指示客户端应该如何缓存，例如max-age=300，表述最多可以缓存300秒

## Request请求+Response响应

## JSP 相对过时

## Cooki+Session 会话技术

## Filter过滤器+Listerer监听器 

## Ajax+Vue+ElementUI

## 综合案例



