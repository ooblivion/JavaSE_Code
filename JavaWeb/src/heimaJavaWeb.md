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

## JDBC

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



## JDBC

JDBC是用Java语言操作关系型数据库的一套API，去MySQL官网下载connection/j -> jar包

### JDBC快速入门

```java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
//哈哈，这都给我连上了。置顶
public class Demo1 {
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

- DriverManager 注册驱动，获取数据库连接

  - ```java
    Class.forName("com.mysql.jdbc.driver");
    ```

- Connection

- Statement

- ResultSet

- PreparedStatement

### 数据库连接池



## Maven

## MyBatis

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

## Ajax+Vue+ElementUI

# Web核心

## Tomcat+HTTP+Servlet

## Request+Response

## JSP

## Cooki+Session

## Filter+Listerer



