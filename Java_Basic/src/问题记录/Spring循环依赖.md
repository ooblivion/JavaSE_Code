## 前言

哈喽大家好，我是一条

最近3天面了大约有10家公司，平均一天三面。

![img](https://inotgo.com/imagesLocal/202108/08/20210808220324659l_0.png)

有趣的是同一天连着三个面试官问到了`循环依赖`问题，这也太高频了吧，为了把这个问题搞透，一条也查了一些资料，做个总结。

以后再有人问你`循环依赖`，拿这篇“吊打”他。

## 概念

### 什么是循环依赖?

多个bean之间相互依赖，形成了一个闭环。比如：A依赖于B、B依赖于C、C依赖于A。

通常来说，如果问Spring容器内部如何解决循环依赖，一定是指默认的单例Bean中，基于`set`方法构造注入的属性互相引用的场景。

循环依赖的种类及能否解决如下：

| 名称                      | 是否可解决循环依赖 |
| :------------------------ | :----------------- |
| 构造器循环依赖            | 否                 |
| Setter循环依赖            | 是                 |
| Prototype作用域的循环依赖 | 否                 |

![img](https://inotgo.com/imagesLocal/202108/08/20210808220324659l_1.png)

### 报错信息

```tex
Unsatisfied dependency expressed through constructor parameter 0; nested exception is org.springframework.beans.factory.BeanCurrentlyInCreationException: Error creating bean with name ‘myDao’: Requested bean is currently in creation: Is there an unresolvable circular reference?
```

翻译一下

```tex
通过构造函数参数 0 表示的依赖关系未得到满足；嵌套的异常是 创建名称为'myDao'的bean时出错。请求的Bean目前正在创建中。是否存在一个无法解决的循环引用？
```

异常信息：bean当前创建异常`org.springframework.beans.factory.BeanCurrentlyInCreationException。`

## 通俗版理解

### 两人拿枪对峙

现在甲乙两个人，互相拿枪对峙，甲说乙先放，乙说甲先放。就是不开枪。

哎，就是玩！

相信这个场景大家在电视剧里都见过吧，最后一般是“反派死于话多”。

但是回到我们 `spring`里，我们是不希望有人死亡的，也就是必须两个`bean`都创建出来，怎么办？

### 必须有一人妥协

解决方案就是：必须有一个人先妥协。

甲说：我退一步，我先把弹夹卸了，你把枪放下。

乙一听就感动了，满含热泪的拿枪放下了。

甲一看乙没有打自己，也热泪盈眶，两人紧紧相拥。

从此过上了幸福美满的生活……

## Spring版理解

回到我们`spring`里，先回顾一下`bean`的生命周期：

- 实例化
- 属性赋值
- 初始化
- 销毁

简单理解一下的上面的过程

### 实例化和初始化什么区别？

是不是只差了中间赋值的过程，那只实例化的`bean`可以使用吗？

当然不可以！

也就是说只实例化的bean是一个半成品，初始化之后才是成品，才可以使用。

现在A依赖B,B依赖A。

> A对B说：我要完整的你
>
> B也对A：我要完整的你

ok，两人打起来了，拿枪对峙。怎么解决？是不是得一个人妥协。

> A说：算了吧，你给我个你的半成品，我将就一下。
>
> B心里寻思，他用我的半成品创建一个完整的A，然后我就可以创建了。
>
> 心里这么想，嘴上就爽快答应着：行，没问题。

如此，A创建了完整的自己，B拿着A也完成了创建。

问题解决。

真的解决了吗？成品和半成品都存在哪里呢？

这就不得不提到大名鼎鼎的三级缓存。

## 三级缓存

> spring提供了三级缓存来存放成品和半成品及工厂。位于`DefaultSingletonBeanRegistry`类中。

```java
public class DefaultSingletonBeanRegistry extends SimpleAliasRegistry implements SingletonBeanRegistry {

/** *一级缓存：单例池 *存放已经初始化的bean——成品 */
private final Map<String, Object> singletonObjects = new ConcurrentHashMap(256);
/** *三级缓存：单例工厂的高速缓存 *存放生成bean的工厂 */
private final Map<String, ObjectFactory<?>> singletonFactories = new HashMap(16);
/** *二级缓存：早期单例对象的高速缓存 *存放已经实例化但未初始化（未填充属性）的的bean——半成品 */
private final Map<String, Object> earlySingletonObjects = new HashMap(16);
}
```

![img](https://inotgo.com/imagesLocal/202108/08/20210808220324659l_2.png)

## 创建过程（简易版）

> 如果你是面试突击，建议把简易版被下来就可以应付面试了
>
> 等有时间再看源码版

假如A依赖B，B依赖A，那么这两个类之间形成了一个循环依赖

- A先开始创建，通过其无参构造方法创建bean的实例，并将其实例放入到「二级缓存」提前暴露出来。A停止。
- B开始创建，先去「一级缓存」找A的成品，找不到，再去「二级缓存」里找，还找不到，再去「三级缓存」里找，找到了A的创建工厂，通过工厂，拿到A的半成品，并将A放到「二级缓存」。
- 拿到A后，B完成创建，将自己放入「一级缓存」。
- 此时A继续创建，同样从「一级缓存」开始找，拿到B后完成创建，将自己放入「一级缓存」。

## 创建过程（源码版）

> 源码版建议配合spring源码边debug边食用。

1、当我们在调用getBean()获取bean时，实际调用的是doGetBean() 方法。doGetBean() 想要获取 beanA ，于是调用 getSingleton() 方法从缓存中查找 beanA

2、在 getSingleton() 方法中，从「一级缓存」中查找，没有，返回 null

3、doGetBean() 方法中获取到 beanA 为 null ，于是走对应的处理逻辑，调用 getSingleton() 的重载方法(参数为 ObjectFactory 的)

4、在 getSingleton()方法中，先将 beanA_name 添加到一个集合中，用于标记该 bean 正在创建中，然后回调匿名内部类的 createBean 方法

5、进入 AbstractAutowireCapableBeanFactory#doCreateBean，先反射调用构造器创建出 beanA 的实例，然后判断，是否为单例，是否允许提前暴露引用（对于单例一般为true）、是否正在创建中（即是否是在第四步的集合中）判断为 true 则将 beanA 添加到「三级缓存」中

6、对 beanA 进行属性填充，此时检测到 beanA 依赖于 beanB ，于是查找 beanB

7、调用 doGetBean() 方法，和上面 beanA 的过程一样，到缓存中查询 beanB ，没有则创建，然后给 beanB 填充属性

8、此时 beanB 依赖于 beanA ，调用 getSingleton() 获取 beanA ,依次从一级、二级、三级缓存中找、此时从「三级缓存」中获取到 beanA 的创建工厂，通过创建工厂获取到 singletonObject ，此时这个 singletonObject 指向的就是上面在 doCreateBean() 方法中实例化的 beanA

9、这样 beanB 就获取到了 beanA 的依赖，于是 beanB 顺利完成初始化，并将 beanA 从「三级缓存」移动到「二级缓存」中

10、随后 beanA 继续他的属性填充工作，此时也获取到了 beanB ，beanA 也随之完成了创建，回到 getSingleton() 方法中继续向下执行，将 beanA 从「二级缓存」移动到「一级缓存」中

![image-20210729201728917](https://inotgo.com/imagesLocal/202108/08/20210808220324659l_3.jpg)