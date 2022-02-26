







## 面向对象

### 封装

### JavaBean

### String

#### 常见面试题

- String创建对象的两种方式有什么不同？
  - 双引号给出的字符串对象存在于堆内存中的常量池，相同内容只会存储一份
  - new字符串对象，每次都会在堆内存中产生一个新的对象
- 

#### String类常用API

- length
- charAt
- toCharArray
- subStirng(int begin, int endIndex) 包前不包后 [)
- subStirng(int begin) 从起始点直接到末尾
- replace(string1, string2) 把字符串1替换为2
- contains
- startsWith
- public String[] split(String s) 按照某个内容将字符串分割成字符数组返回

#### String案例

- 需求1：随机产生一个5的验证码，可能是数字和大小写字母

- 分析

  - 定义一个String类型的变量存储a-zA-Z0-9之间的全部字符
  - 循环5次，随机一个范围内的索引，获取对应字符连接起来即可

- 代码

  ```java
  public class StringDemo1 {
      public static void main(String[] args) {
          //定义可能出现的字符信息
          String data = "a...A...0...";
  
          //循环5次，每次生成一个随机索引，提取对应的字符串连接起来即可
          String code = "";
          Random r = new Random();
          for (int i = 0; i < 5; i++) {
              int index = r.nextInt(data.length());
              char c = data.charAt(index);
              code+=c;
          }
  
          //输出字符串变量即可
          System.out.println(code);
      }
  }
  ```

- 需求2：模拟用户登录功能，最多只给三次机会
- 分析
  - 系统后台定义好正确的登录名称，密码
  - 使用循环控制三次，让用户输入正确的登录名和密码，判断是否登录成功，登录成功则不再进行登录，登录失败则给出提示，让用户继续登录，最多三次
- 代码

### 继承

### 多态

#### 优点

#### 案例

#### 概述

#### 类型转换

```java
public abstract class Animal {
    public String name = "父类动物";
    public abstract void run();
}
```

```java
public class Dog extends Animal {
    public String name = "子类狗";
    @Override
    public void run() {
        System.out.println("dog run quick");
    }
    public void brack(){
        System.out.println("w w w");
    }
}
```

```java
public class Tortoise extends Animal {
    @Override
    public void run() {
        System.out.println("tortoise slow");
    }
}
```

```java
//为了调用子类的独有功能
//强制类型转换能解决什么问题？需要注意什么？
//  可以转换成真正的子类型，从而调用子类独有的功能
//  有继承或实现的两个类型就可以使用强制类型转换，编译无问题
public class Demo {
    public static void main(String[] args) {
        Animal a1 = new Dog();
        Animal a2 = new Tortoise();

        a1.run();
        a2.run();
        //a1.brack();

        //强制类型转换，父类转子类
        Dog d = (Dog)a1;
        d.brack();

        //编译阶段不报错，有继承或实现关系，编译阶段可以强制
        //ClassCastException
        Dog dd = (Dog) a2;

        //转换类型后如果和真实类型不一样，会抛出异常ClassCastException
        //建议在使用之前先用instanceof判断当前对象的真是性，再进行强制类型转换

        if(a1 instanceof Dog){
            Dog ddd = (Dog) a1;
            ddd.brack();
        }else if (a1 instanceof Tortoise){
            Tortoise t = new Tortoise();
            //t.special_mothod()
        }
    }

}
```

### 内部类

#### 概述

```java
public class People {

    public class Heart{

    }
}
//一个事物内部还有一个部分需要一个完整的结构描述，而这个额内部的完整结构又只为外部服务，这时候需要使用内部类
//内部类通常可以方便访问外部类的成员，包括私有成员
//内部类提供了更好的封装性，内部类本身就可以用private protected修饰，封装性可以做更多控制
```

#### 内部类分类

##### 静态内部类

##### 成员内部类

##### 局部内部类

##### 匿名内部类



#### 匿名内部类常见使用形式

匿名内部类可以作为方法的形参进行传输

#### 匿名内部类真实使用场景

开发中不是我们主动去定义匿名内部类，而是别人需要我们写或者我们可以写的时候才会使用，匿名内部类可以进一步简化代码

```java
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @version v1.0
 * @ClassName: Client
 * @Description: TODO 类描述
 * @Author: Orange
 **/
public class Client {
    public static void main(String[] args) {
        //1. 创建窗口
        JFrame win = new JFrame("登录界面");
        JPanel panel = new JPanel();
        win.add(panel);

        //2. 创建一个按钮对象
        JButton btn = new JButton("登录");

        //注意：匿名内部类使用
//        btn.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                JOptionPane.showMessageDialog(win, "点你一下");
//            }
//        });
        //lambda表达式简化
        btn.addActionListener(e -> JOptionPane.showMessageDialog(win,"哈哈"));

        //3. 把按钮对象添加到桌布展示
        panel.add(btn);

        //4. 展示窗口
        win.setSize(400, 300);
        win.setLocationRelativeTo(null);
        win.setVisible(true);
    }
}
```



### 常用API

#### Object

- toString()：返回当前对象在堆内存中的地址信息
- equals()：默认比较当前对象那个与哪一个对象的地址是否相同，相同返回true

子类需要重写父类的toString

- Object的equals方法的作用是什么？
  - 默认的与哪一个对象比较地址是否一样
  - 让子类重写，以便比较两个子类对象的内容是否相同

#### Objects

Objects与Object是继承关系，但在比较字符串时，没有对象自己的equals方法，而是选择了Objects的equals方法来比较两个对象

Objects的equals方法比较的结果是一样的，但是更安全（内部其实还是调用的Object的equals，只不过在判断之前进行了非空校验

- 对象进行内容比较的时候建议使用什么？
  - 建议使用Objects提供的equals方法
  - 比较的结果是一样的，但是更安全

#### StringBuilder

- 概述
  - 这是一个可变的字符串类，，可以看作是一个对象的容器
- 构造器
  - stringBuilder()：创建一个空白的可变字符对象，不包含任何内容
  - StirngBuilder(String str)：创建一个指定字符串内容可变的字符串对象
- 目标：学会使用StringBuilder操作字符串，最终还需要知道它性能好的原因
- 为什么拼接，反转字符串建议使用StirngBuilder？
  - String：内容是不可变的，拼接字符串性能较差
  - StringBuilder：内容是可变的，拼接字符串性能好
  - 定义字符串使用String
  - 拼接，修改等操作字符串使用StringBuilder
- 需求：设计一个方法用于输出任意整型内容，格式：”该数组内容为：[11, 22, 33, 44, 55]“
  - 分析
    - 定义一个方法，该方法能够接收数组，并输出数组内容（需要参数吗？需要返回值类型申明吗？
    - 定义一个静态初始化数组，调用该方法，并传入该数组
  - 代码

#### Math

四舍五入 round pow floor ceil abs 

- 随机数 random
  - 3~9之间的随机整数
    `(0~6)+3`
    `[0~1)*6`
    `[0~1)*7`
    `int data = (int)(Math.random() * 7) + 3` 

#### System

- exit(int status)
  - `System.exit(0);` JVM终止
- cuttentTimeMills()
- arraycopy(数据源数组, 起始索引, ,目的地数组, 起始索引, 拷贝个数);

#### BigDecimal

- `public BigDecimal add(BigDecimal b);`
- `public BigDecimal subtract(BigDecimal b);`
- `public BigDecimal multiply(BigDecimal b);`
- `public BigDecimal divide(BigDecimal b);`
- `public BigDecimal divide (BigDecimal b, 精确几位, 舍入模式);`

补充

- 禁止使用构造方法 BigDecimal(double) 的方式把 double 值转化为 BigDecimal 对象。
- 说明：BigDecimal(double)存在精度损失风险，在精确计算或值比较的场景中可能会导致业务逻辑异常。
  如：`BigDecimal g = new BigDecimal(0.1f);` 实际的存储值为：0.10000000149
- 正例：优先推荐入参为 String 的构造方法，或使用 BigDecimal 的 valueOf 方法，此方法内部其实执行了
  Double 的 toString，而 Double 的 toString 按 double 的实际能表达的精度对尾数进行了截断。
  `BigDecimal recommend1 = new BigDecimal("0.1");`
  `BigDecimal recommend2 = BigDecimal.valueOf(0.1);`

- 将BigDecimal转换为double `double rc =  recommand2.doubleValue();`

- `BigDeimal test = (10.0).divide(3.0, 2, )`

### 日期与时间

- Date
- SimpleDateFormat
- Calendar

### JDK8新增日期类

### 包装类

- 

### Arrays类

### 常见算法

### Lambda表达式

#### 概述

- JDK8开始使用

- 作用：简化匿名内部类的代码写法

  ```java
  (匿名内部类被重写方法的形参列表)->{
      被重写方法的具体代码
  }
  ```

- 注意：Lambda表达式只能简化函数接口的匿名内部类的写法形式

- 什么是函数式接口？

  - 首先必须是接口，其次几口中仅有一个抽象方法的形式
  - 通常会加上一个`@FunctionalIneterface`注解，标记该接口必须满足函数式接口

- Lambda表达式的基本作用

  - 简化函数式接口的匿名内部类的写法

- Lambda表达式有什么使用前提

  - 必须式接口的匿名内部类，接口中只能有一个抽象方法

- Lambda的好处

  - Lambda式一个匿名函数，可以理解为式一段可以传递的代码，可以写出更简洁，更灵活的代码。作为一种更紧凑的代码风格，使Java语言表达能力得到了提升

#### 简化常见函数式接口

#### Lambda表达式的省略规则

### 



## IO流

## 正则表达式

### 入门案例

- 校验QQ号码是否正确

  ```java
  public class RegQQDemo {
      //校验QQ号码，必须全部数字6~20个
      public static void main(String[] args) {
          System.out.println(checkQQ("3255dwf332"));//false
          System.out.println(checkQQ("325332432"));//true
  
          System.out.println("===");
  
          System.out.println(regCheckQQ("3255dwf332"));//false
          System.out.println(regCheckQQ("325332432"));//true
      }
  
      public static boolean regCheckQQ(String qq){
          return qq != null && qq.matches("\\d{6,20}");
      }
  
      public static boolean checkQQ(String qq){
          //1. 判断qq号码的长度是否满足要求
          if(qq == null || qq.length() < 6 || qq.length() >20){
              return false;
          }
          //判断qq中是否全是数字，不是返回false
          //3243215we12
          for (int i = 0; i < qq.length(); i++) {
              //获取每个字符
              char ch = qq.charAt(i);
              //判断这个字符是否不是数字，不是数字直接返回false
              if(ch < '0' || ch > '9'){
                  return false;
              }
          }
          return true;
      }
  }
  ```

### 匹配规则

- 字符类

  - `[abc]`
  - `[^abc]`
  - `[a-zA-Z]`
  - `[a-d[m-p]]` a-d或m-p
  - `[a-z&&[def]]` 两个取交集，也就是def
  - `[a-d&&[^bc]]` abcd排除bc，也就是ad
  - `[a-d&&[^b-d]]` abcd排除bcd，也就是a

- 预定义字符类

  - `.` 任何字符
  - `\d` 任何数字 `[0-9]`
  - `\D` 非数字 `[^0-9]`
  - `\s` 一个空白字符 `[\t\n\x0B\f\r]`
  - `\S` 非空白字符 `[^\s]`
  - `\w` 英文，数字，下划线 `[a-zA-Z_0-9]`
  - `\W` 一个非单词字符 `[\W]` 

- 量词

  - `a?` 0/1
  - `a*` >=0 
  - `a+` >=1
  - `a{n}` =n
  - `a{n,}` >=n
  - `a{n,m}` >n&&<m

- 匹配正则表达式规则的API

  - `public boolean matches(String regex)`

- 匹配四位验证码案例

  ```java
  public static void main(String[] args) {
      //四位数验证码
      String s1 = "1ws2";
      String s2 = "ss_1";
      String regex1 = "[a-zA-Z0-9]{4}";
      String regex2 = "[\\w && ^_]{4}";
      String regex3 = "[\\w && [^_]]{4}";
      System.out.println(s1.matches(regex1));//true
      System.out.println(s1.matches(regex2));//false ? 有问题 在[]中排除必须用[]
      System.out.println(s1.matches(regex3));//true
      System.out.println("===");
      System.out.println(s2.matches(regex1));//false
      System.out.println(s2.matches(regex2));//false
      System.out.println(s2.matches(regex3));//false
  }
  ```

  

### 常见案例

- 模拟用户输入手机号码，验证格式正确并给出提示，直到正确为止

  - 分析

    - 定义方法用于接收用户输入数据，使用正则表达式完成检验，并给出提示

  - 代码

    ```java
    public static void checkPhone(){
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("请输入手机号");
            String phone = scanner.next();
            //判断手机号是否正确
            if(phone.matches("1[3-9]\\d{9}")){
                System.out.println("手机号格式正确");
                break;
            }else {
                System.out.println("手机号格式错误");
            }
        }
    }
    ```

- 模拟匹配邮箱

  - 代码

    ```java
    public static void checkEmail(){
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("请输入邮箱号码：");
            String email = scanner.next();
            //23432453@qq.com
            //214324532@163.com
            //4365243ds4325@pci.com.cn
            if(email.matches("\\w{1,30}@[a-zA-Z0-9]{2,20}(\\.[a-zA-Z0-9]{2,20}){1,2}")){
                System.out.println("邮箱格式正确");
                break;
            }else {
                System.out.println("邮箱格式有误");
            }
        }
    }
    ```

- 其他应用

```
1.验证用户名和密码：（"^[a-zA-Z]\w{5,15}$"）正确格式："(?!^\\d+$)(?!^[a-zA-Z]+$)(?!^[_#@]+$).{8,}"组成,并且第一个字必须为字母6~16位；
2.验证电话号码：（"^(\d{3,4}-)\d{7,8}$"）正确格式：xxx/xxxx-xxxxxxx/xxxxxxxx；
3.验证手机号码："^1[3|4|5|7|8][0-9]\\d{8}$"；
4.验证身份证号（15位或18位数字）："\d{14}[[0-9],0-9xX]"；
5.验证Email地址：("^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$")；   wwt2333@gmail.com
6.只能输入由数字和26个英文字母组成的字符串：("^[A-Za-z0-9]+$")；
7.整数或者小数：^[0-9]+([.][0-9]+){0,1}$
8.只能输入数字："^[0-9]*$"。
9.只能输入n位的数字："^\d{n}$"。
10.只能输入至少n位的数字："^\d{n,}$"。
11.只能输入m~n位的数字："^\d{m,n}$"。
12.只能输入零和非零开头的数字："^(0|[1-9][0-9]*)$"。
13.只能输入有两位小数的正实数："^[0-9]+(\.[0-9]{2})?$"。
14.只能输入有1~3位小数的正实数："^[0-9]+(\.[0-9]{1,3})?$"。
15.只能输入非零的正整数："^\+?[1-9][0-9]*$"。
16.只能输入非零的负整数："^\-[1-9][0-9]*$"。
17.只能输入长度为3的字符："^.{3}$"。
18.只能输入由26个英文字母组成的字符串："^[A-Za-z]+$"。
19.只能输入由26个大写英文字母组成的字符串："^[A-Z]+$"。
20.只能输入由26个小写英文字母组成的字符串："^[a-z]+$"。
21.验证是否含有^%&',;=?$\"等字符："[%&',;=?$\\^]+"。
22.只能输入汉字："^[\u4e00-\u9fa5]{0,}$"。
23.验证URL："^http://([\w-]+\.)+[\w-]+(/[\w-./?%&=]*)?$"。
24.验证一年的12个月："^(0?[1-9]|1[0-2])$"正确格式为："01"～"09"和"10"～"12"。
25.验证一个月的31天："^((0?[1-9])|((1|2)[0-9])|30|31)$"正确格式为；"01"～"09"、"10"～"29"和“30”~“31”。
26.获取日期正则表达式：\\d{4}[年|\-|\.]\d{\1-\12}[月|\-|\.]\d{\1-\31}日?
评注：可用来匹配大多数年月日信息。
27.匹配双字节字符(包括汉字在内)：[^\x00-\xff]
评注：可以用来计算字符串的长度（一个双字节字符长度计2，ASCII字符计1）
28.匹配空白行的正则表达式：\n\s*\r
评注：可以用来删除空白行
29.匹配HTML标记的正则表达式：<(\S*?)[^>]*>.*?</>|<.*? />
评注：网上流传的版本太糟糕，上面这个也仅仅能匹配部分，对于复杂的嵌套标记依旧无能为力
30.匹配首尾空白字符的正则表达式：^\s*|\s*$
评注：可以用来删除行首行尾的空白字符(包括空格、制表符、换页符等等)，非常有用的表达式
31.匹配网址URL的正则表达式：[a-zA-z]+://[^\s]*
评注：网上流传的版本功能很有限，上面这个基本可以满足需求
32.匹配帐号是否合法(字母开头，允许5-16字节，允许字母数字下划线)：^[a-zA-Z][a-zA-Z0-9_]{4,15}$
评注：表单验证时很实用
33.匹配腾讯QQ号：[1-9][0-9]{4,}
评注：腾讯QQ号从10 000 开始
34.匹配中国邮政编码：[1-9]\\d{5}(?!\d)
评注：中国邮政编码为6位数字
35.匹配ip地址：([1-9]{1,3}\.){3}[1-9]。
评注：提取ip地址时有用
36.匹配MAC地址：([A-Fa-f0-9]{2}\:){5}[A-Fa-f0-9]
Function IsRegu(Regu,s)
'正则表达式校验
If Regu="" Then
Exit Function
End if
Dim Re,Sre
Set Re = New RegExp
Re.Pattern = Regu
Sre = Re.Test(s)
If Sre = True Then
IsRegu = True
Else
IsRegu = False
End If
End Function
tmp=" "
if (IsRegu("\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*",tmp )) =false then
msgbox "E-mail地址不合法 ！"
FieldCheck#N=false
不同的语言（如PHP和JAVA）、相同语言的不同类库（如来自Sun的Java Regular Expression类库跟Apache Jakarta的正则表达式类库）间，用法会有所差别，在使用的时候，要注意这些差别。
验证URL
functionIsValidUrl(str){
varregu="^(https?://)"
+"?(([0-9a-z_!~*'().&=+$%-]+:)?[0-9a-z_!~*'().&=+$%-]+@)?"
+"(([0-9]{1,3}\.){3}[0-9]{1,3}"
+"|"
+"([0-9a-z_!~*'()-]+\.)*"
+"([0-9a-z][0-9a-z-]{0,61})?[0-9a-z]\."
+"[a-z]{2,6})"
+"(:[0-9]{1,4})?"
+"((/?)|"
+"(/[0-9a-z_!~*'().;?:@&=+$,%#-]+)+/?)$";
varre=newRegExp(regu);
if(!re.test(str)){
return false;
}
return true;
}

```

### 正则表达式在方法中的应用

### 爬取信息/爬虫

```java
Pattern pattern = Pattern.compile(regex);//将字符串内容编译成匹配规则
Matcher matcher = pattern.matcher(str);//通过匹配规则获取匹配器
while(matcher.find){
    System.out.println(matcher.group());
}
```





正则表达式其他

```java
"^\\s*\\w+(?:\\.{0,1}[\\w-]+)*@[a-zA-Z0-9]+(?:[-.][a-zA-Z0-9]+)*\\.[a-zA-Z]+\\s*$"  
  
这个是一个企业级的程序里copy出来的。  
合法E-mail地址：   
1. 必须包含一个并且只有一个符号“@”   
2. 第一个字符不得是“@”或者“.”   
3. 不允许出现“@.”或者.@   
4. 结尾不得是字符“@”或者“.”   
5. 允许“@”前的字符中出现“＋”   
6. 不允许“＋”在最前面，或者“＋@”   
  
正则表达式如下：   
-----------------------------------------------------------------------   
^(\w+((-\w+)|(\.\w+))*)\+\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$   
-----------------------------------------------------------------------   
  
字符描述：   
^ ：匹配输入的开始位置。   
\：将下一个字符标记为特殊字符或字面值。   
* ：匹配前一个字符零次或几次。   
+ ：匹配前一个字符一次或多次。   
(pattern) 与模式匹配并记住匹配。   
x|y：匹配 x 或 y。   
[a-z] ：表示某个范围内的字符。与指定区间内的任何字符匹配。   
\w ：与任何单词字符匹配，包括下划线。   
$ ：匹配输入的结尾。  
  
参考资料：http://www.1-100.org/asp/2006/10273.htm  

import java.util.regex.Matcher;  
import java.util.regex.Pattern;  
  
/** 
 * <p> 
 * 
 * <p>Copyright the original author or authors. 
 * 
 * @author Liu Huibin 
 * @date Aug 27, 2010 
 * @dateLastModified Aug 27, 2010 
 */  
public class Test {  
public static void main(String[] args) {  
  
//电子邮件  
 String check = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";  
 Pattern regex = Pattern.compile(check);  
 Matcher matcher = regex.matcher("dffdfdf@qq.com");  
 boolean isMatched = matcher.matches();  
 System.out.println(isMatched);  
 /* 电话号码 
 
String check = "^(13[4,5,6,7,8,9]|15[0,8,9,1,7]|188|187)\\d{8}$"; 
 Pattern regex = Pattern.compile(check); 
 Matcher matcher = regex.matcher("13555655606"); 
 boolean isMatched = matcher.matches(); 
 System.out.println(isMatched); 
 
*/  
}  
}  
如何在插入数据库后返回增加的唯一ID值 | encodeURIComponent编码后java后台的解码
```

## 异常

关于异常，对于RuntimeException异常和Exception要区分

### 异常概述，分类，认识

- 什么是异常
  - 异常是程序在编译或者运行的过程中可能出现的问题，**语法错误不算异常**
  - 比较典型的异常有：数组索引越界，空指针异常，日期格式化异常，类型转换异常，算数异常
- 为什么要学习异常？
  - 异常一旦出现了，如果没有处理，程序就会退出虚拟机而终止
  - 研究异常并且避免异常错误，人后提前处理异常，体现程序的安全性和健壮性
- 异常体系 Throwable
  - **Error** 系统级别问题，JVM退出等，代码无法控制
  - **Exception**：java.lang包下，称为异常类，它表示程序本身可以处理的异常
    - **RuntimeException**：运行时异常，编译阶段不会报错
      - 空指针异常 NullPointer 直接输出没问题，但是调用空指针的变量就会报错
      - 数组索引越界异常 ArrayIndexOutOfBounds
      - 数学操作异常 Arithematic
      - 类型转换异常 ClassCast
      - 数字转换异常 NumberFormat
    - **除RuntimeException之外的所有异常**：编译异常，编译期必须处理，否则程序无法通过编译
      - IO流中的异常
      - 日期格式化异常
- 编译时异常和运行时异常
  - Java文件 .java
  - -- Javac.exe -- 编译时异常，是在编译成class文件时必须要处理的异常，也称之为受检异常
  - 字节码文件 .class
  - -- Java.exe -- 运行时异常，在编译成class文件不需要处理，在运行字节码文件的时候可能出现的异常

### 自定义异常

- 自定义编译时异常
  - 定义一个异常类继承Exception
  - 重写构造器
  - 在出现异常的地方用throw new 自定义对象抛出
  - 编译时异常在编译阶段就会报错，一定要处理
- 自定义运行时异常
  - 定义一个异常类继承RuntimeException
  - 重写构造器
  - 在出现异常的地方用throw new 自定义对象抛出



## 多线程

## 单元测试

### 单元测试概述

- 什么是单元测试
  - 单元测试就是针对最小的功能单元编写的测试代码，Java程序最小的功能单元是方法，因此单元测试就是针对Java方法的测试，进而检查方法的正确性
- 目前测试方法是如何进行的？存在什么问题
  - 只有一个main方法，如果其中的方法失效了，其他的测试方法也会收到影响
  - 无法得到测试的结果报告，需要自己去观察测试是否成功
  - 无法实现自动化测试
- JUnit单元测试框架
- JUnit优点
  - 可以灵活的选择执行哪些测试方法，可以以一键执行全部测试方法
  - JUnit可以生成全部方法的测试报告
  - 单元测试中的某个方法测试失败后，不会影响其他方法的测试
- 总结
  - JUnit单元的的作用
    - 测试类中方法的正确性
  - JUnit单元的测试优点
    - JUnit可以选择执行哪些测试方法，可以一键执行全部测试方法的测试
    - JUnit可以生成测试报告，如果测试良好则是绿色，如果测试失败则是红色
    - 单元测试中的某些方法失效不会影响其他测试方法的测试

### 单元测试入门

- 需求：使用单元测试进行业务方法预期结果，正确性测试的快速入门
- 分析
  - 将JUnit的jar包导入到项目中
  - 编写测试方法：该方法必须是公共的无参数，无返回值的非静态方法
  - 在测试方法的基础上使用@Test注解：表述该方法是一个测试方法
  - 选中测试方法，选择“JUinit运行”，如果测试良好则为绿色
- 总结
  - JUnit单元测试的实现过程是怎么样的？
    - 必须导入JUnit框架的jar包（如何导入jar包？
    - 定义的测试方法必须是无参数无返回值，而且被public修饰
    - 测试方法需要使用@Test注解标记

### 单元测试的常用注解

- 4.0版本
  - @Test：测试方法
  - @Before：用来修饰实例方法，该方法会在每个测试方法执行之前执行一次
  - @After：用来修饰实例方法，该方法会在每一个测试方法执行之后执行一次
  - @BeforeClass：用来静态修饰方法，该方法会在所有测试方法执行之前执行一次
  - @AfterClass：用来静态修饰方法，该方法会在所有测试方法之后执行一次

## 反射&注解





## XML





