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