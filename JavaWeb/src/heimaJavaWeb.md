

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



