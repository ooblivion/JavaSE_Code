## 一、基本介绍

### 1、定义

享元模式(FlyWeight)，又称为蝇量模式，常用于有着大量重复使用的细粒度对象时。实质上是一种共享技术。

### 2、优点

利用享元池，可以使得用户在调用一个对象时可以不必去new，只需要在享元池中直接获取即可，节约了内存空间。

注:太多的对象不仅会影响性能，更严重的情况下可能会造成内存溢出

### 3、缺点

1)逻辑会更加的复杂。

2)对于一些享元池中不能直接取出的对象，还是需要去new，这时利用了享元模式获取对象的时间会变得更长。

### 4、角色

#### 1)抽象享元类

接口/抽象类

#### 2)具体享元类

实现接口或者抽象类的具体子类，这些子类会被大量的重复使用，而且这些子类对象都是细粒度。

#### 3)享元工厂类

工厂其实就是一个享元池

#### 4)组合享元类

组合享元类是依赖基本享元类产生的一个整体类，例如享元池中，如果有字符A、B，我们其实可以利用这两个字符对象构成一个AB字符串，这就是一个组合享元类。

### 5、内部状态和外部状态



细粒度对象，当对象数量较多时不可避免性质相似，如何区分如此多的不同的细粒度对象呢?此时我们就将这些对象的信息分为两个部分：内部状态和外部状态。

内部状态指对象共享出来的信息，存储在享元对象内部并且不会随环境的改变而改变；

外部状态指对象得以依赖的一个标记，是随环境改变而改变的、不可共享的状态。

如何理解内部状态和外部状态呢?

比如坦克大战中，有着不同类型的子弹，这些子弹就是因为内部状态的不同而改变的，例如是燃烧弹还是烟雾弹就是看其内部状态了。但是我们的坦克可以朝着不同的方向发射子弹，子弹的方位坐标就是子弹的一个外部状态了。

再比如为围棋，只有黑白两颗子，内部状态控制颜色，而外部状态控制棋在棋中的位置。

## 二、应用情景

### 1、线程池

### 2、String

在JVM中有一个字符串常量池，例如，当String="a"时，并不是直接在堆中`new String("a")`，而是会先去常量池中进行查询，如果常量池中有“a"，则直接会返回常量池中字符串"a"的引用地址。字符串相加，其实是调用了StringBuilder()的append，然后再toString，所以相加后的引用不在常量池而在堆中。

[![img](https://inotgo.com/imagesLocal/202103/25/20210325225400592g_0.png.jpg)](https://inotgo.com/imagesLocal/202103/25/20210325225400592g_0.png.jpg)

### 3、Integer

在Integer中，也有一些已经存在的对象(-128,127),这些对象被放入缓冲区中，当`Integer a=1;`或者`Integer a=Integer.ValueOf(1)`时，就会先与缓冲区中的对象相匹配，如果缓冲区有，则直接返回缓冲区中的对象，没有的话，例如128在缓冲区没有，就只能`return Integer a=new Integer(128);`

[![img](https://inotgo.com/imagesLocal/202103/25/20210325225400592g_1.png.jpg)](https://inotgo.com/imagesLocal/202103/25/20210325225400592g_1.png.jpg)

### 4、五子棋

在五子棋游戏中，如果共需要500多颗黑白子，那么在没有利用享元模式或者单例模式时，我们就必须要new500多个对象,然而，如果利用享元模式，就可以只有两个对象:一个黑棋，一个白棋。[注:单例模式也可以实现]，这样极大的节省了内存的空间，也节省了new的时间，空间和时间性能都有着极大的提升。

## 三、与其他模式的搭配使用

享元模式通常与单例模式、组合模式、工厂模式搭配使用。

### 1）单例模式

工厂可以使用单例模式.(前提是工厂不是泛型工厂)

### 2）组合模式

复合的享元模式是使用了组合模式的

### 3）工厂模式

工厂其实就是一个享元池

## 四、代码解析

```java
//抽象享元
package pattern.flyweight;
public abstract class FlyWeight {
//内部状态
String instate;
//外部状态
String outstate;
public FlyWeight(String outstate) {
this.instate = outstate;
}
abstract void show();
//获取或者设置内部状态
public String getInstate() {
return instate;
}
public void setInstate(String instate) {
this.instate = instate;
}
}
//具体享元
package pattern.flyweight;
public class A extends FlyWeight{
public A(String outstate) {
super(outstate);
}
//根据外部状态进行一系列的逻辑操作
@Override
void show() {
// TODO Auto-generated method stub
System.out.println(outstate);
}
}
//享元工厂
package pattern.flyweight;
import java.util.HashMap;
import java.util.Map;
//泛型时，不能用单例模式，否则泛型将会没有意义
public class FlyWeightFactory {
private FlyWeightFactory() {
};
private static FlyWeightFactory INSTANCE = null;
public static FlyWeightFactory getINSTANCE() {
if (INSTANCE == null) {
synchronized (FlyWeightFactory.class) {
if (INSTANCE == null)
INSTANCE = new FlyWeightFactory();
}
}
return INSTANCE;
}
static Map<Character, FlyWeight> FlyWeightMap = new HashMap<Character, FlyWeight>();
public FlyWeight getConcreteFlyWeight(char c, String b) {
if (!FlyWeightMap.containsKey(c))
FlyWeightMap.put(c, new A(b));
return FlyWeightMap.get(c);
}
}
```

[![img](https://inotgo.com/imagesLocal/202103/25/20210325225400592g_2.png)](https://inotgo.com/imagesLocal/202103/25/20210325225400592g_2.png)

UML图:

[![img](https://inotgo.com/imagesLocal/202103/25/20210325225400592g_3.png)](https://inotgo.com/imagesLocal/202103/25/20210325225400592g_3.png)

几行代码真的很难说清享元模式，而且也没有找到比较合适的例子，所以只能在这里简单介绍了基本享元模式，文中测试也只测试了a和b是否是指向同一引用，在一些规模比较小的程序中享元模式的优点真的是很难体现出来，如果还是有很多疑惑可以去查看java源码，线程池和Integer的缓冲区等都非常牛的运用了享元模式。