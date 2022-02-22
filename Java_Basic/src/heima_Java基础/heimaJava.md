









## 基础语法

### 注释

### 字面量

### 变量

### 变量的使用注意事项

- 定义时可以没有初始化值，但是使用的时候必须有初始化值
- 变量声明后不能有存放其他类型的数据
- 变量需要先声明再使用
- `{...}`在作用域内不能定义两个同名变量

### 变量在计算机种的底层原理

- 变量存储是数据二进制形式
- 数据变二进制的规则：2进1
- 文字如何存储到计算机底层（ASCII码）
  - 存储字符对应数字的二进制形式
  - `'a' -> 97 -> 01100001`
- 图片，视频等存储的都是二进制形式

### 数据类型

- 注意事项
  - 整数默认int，相当于long类型后面加L/l
  - 小数默认double，相当于float类型后面加F/f

### 关键字，标志符

### 类型转换

- 什么是类型转换
  - 类型范围小的，可以直接赋给类型范围大的变量
    - byte -> short -> int -> long -> float ->double
  - 类型范围大的转换为小的时候需要强制转换，而且会丢失精度
  - 注意事项
    - 强制类型转换可能造成数据丢失或溢出
    - 浮点型转换为整型，直接丢掉小数部分，保留整数部分返回

### 运算符

#### 基本运算符

#### +符号作连接符

```java
public class Demo {
    public static void main(String[] args) {
        int a = 5;
        System.out.println("abc" + 'a');//abca
        System.out.println("abc" + a);//abc5
        System.out.println(5 + a);//10
        System.out.println("abc" + 5 + 'a');//abc5a
        System.out.println(15 + "abc" + 15);//15abc15
        System.out.println(a+'a');//102
        System.out.println(a+""+'a');//5a
        System.out.println(a+'a'+"java");//102java
        System.out.println("java"+a+'a');//java5a
        System.out.println("java"+(a+'a'));//java102
    }
}
```

#### 自增自减运算符

#### 赋值运算符

#### 关系运算符

#### 逻辑运算符

#### 三元运算符

#### 运算符优先级

### 案例：键盘录入

### 数组

数组内存图

Java内存分配

- 栈：方法运行时所进入的内存
- 堆：new出来的东西会在这片内存中开辟空间并产生地址
- 方法区：字节码加载时进入的内存
- 本地方法栈
- 寄存器/程序计数器

#### 常见使用问题

- 超过最大索引， ArrayIndexOutOfBoundsException
- 变量中没有存储数组地址而是null，NullPointerException

## 面向对象

### 封装

### JavaBean

### String

#### 常见面试题

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

### JDK8新增日期类

### 包装类

### 正则表达式

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

## 集合Collection

### basi

### List

#### ArrayList

- 常用API
  - get(int index)
  - size()
  - E remove(int index)
  - boolean remove(Object o) 
  - E set(int index, E element)

#### LinkdeList

### Set

### 集合概述

集合和数组都是容器

- 数组定义完成并启动后，类型和长度都确定
- 在增删数据操作时，数组不太合适，增删数据都需要放弃原有数组或移位

- 数组适合的场景
  - 业务数据的个数确定，并且都是同一种数据类型

- 集合是Java中存储对象的一种容器

- 集合的大小不固定，启动后可以动态变化，类型也可以选择不固定
- 集合适合的场景
  - 元素的增删操作
- 注意：集合只能存储引用数据类型，如果要存储基本数据类型需要使用包装类



#### 总结

- 数组和集合储存元素的个数
  - 数组定义后类型确定，大小固定
  - 集合类型可以不固定，大小可变
- 元素类型问题
  - 数组可以存储基本类型和引用类型
  - 集合只能存储引用类型
- 适用场景
  - 数组适合数据个数和类型都确定的场景
  - 集合适合数据个数不去确定，而且频繁增删元素的场景（而且集合的功能更加丰富

### 集合的体系特点

- 集合
  - Collection 单列 每个元素只包含一个值
    - List 添加元素是有序的，可重复，有索引
      - ⭐ArrayList
      - LinkedList
    - Set 添加元素无序，不重复，无索引
      - HashSet 添加元素无序，不重复，无索引
        - LinkedHashSet 有序，不重复，无索引
      - TreeSet 按照大小默认升序排序，不重复，无索引
  - Map 双列 每个元素包含两个值（键值对 key-value
- 集合对于泛型的支持
  - 集合都是支持泛型的，可以在编译阶段约束集合只能操作某种数据类型
  - JDK1.7以后，后面的泛型类型申明可以省略
- 注意
  - 集合和泛型都只支持引用数据类型，不支持基本数据类型，所以集合中存储的元素都认为是对象
  - 若要使用基本基本数据类型可以用包装类

#### 其他问题

- 

### 集合常用API

- add 
- addAll
- contain 
- clear 
- isEmpty 
- remove 
- size 
- toArray

### 集合的遍历方式

#### 迭代器遍历概述

- 遍历就是将容器中的所有元素全部访问呢一遍
- 在Java中的迭代器是`Iterator`，迭代器是集合专用的遍历方式

#### Collection集合获取迭代器

- Collection
  - `Iterator<E> iterator()` 默认指向集合的0索引
- Iterator
  - `boolean hasNext()`
  - `E next()`
  - `default void forEachRemaining(Consumer<? super E> action)`
  - `default void remove()`

一个while循环中只能有一个it.next

### 集合储存自定义类型的对象

### 常见的数据结构

### List系列集合

### 补充：集合的并发修改异常问题

### 泛型深入

### Set系列集合

### Collection体系的特点，使用场景总结

### 补充知识：可变参数

### 不充知识：集合工具类Collections

### Collection体系的案例综合

## Map集合体系

### 概述

### 特点

### 常用API

- put(E e, E e)
- remove 
- clear
- containKey
- containValue
- isEmpty
- size
- KeySet
  - `Set<String> sets = maps.KeySet()` 多态
- 获取全部值的集合 `Collection<V> value()`
- 合并集合 putAll

### 遍历 键值对

### 遍历 键找值

### 遍历 Lambda表达式

### Map集合实现类之HashMap

### Map集合实现类之LinkedHashMap

### Map集合实现类之TreeMap

### 补充知识：集合的嵌套



## IO流



## 异常

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



## 网络编程

- 网络通信的基本模式
  - CS：客户端需要程序员开发，用户需要安装客户端。Server需要程序员开发实现
  - DS：用户需要安装浏览器，Server需要程序员开发实现

### 网络通信的三要素

#### IP地址

- 定义：设备在网络中的地址，是唯一标识

#### IP地址操作类-InetAddress

#### 端口号

- 定义：应用程序在设备中的唯一标识

#### 协议

- 定义：数据在网络中传输的规则，常见的协议哟TCP/

### UDP通信

性能高一些

#### UDP快速入门

#### 广播&组播

### TCP通信

#### TP快速入门

#### 多发多收集消息

#### 同时接收多个客户端的消息

#### 使用线程池进行优化

### TCP通信模拟实战

#### 即时通信

#### 模拟BS系统

以后的重心是学习Browser-Server的开发

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





