package heima_Java基础.面向对象.抽象类.概述;

/**
 * @version v1.0
 * @ClassName: Animal
 * @Description: TODO 类描述
 * @Author: Orange
 **/
public abstract class Animal {
    public abstract void run();
}
/*
- 抽象类要被子类继承，抽象方法是交给子类重写实现的
- 一个类如果继承了抽象类，这个类必须重写完成抽象类的所有抽象方法，否则这个类还是抽象类

抽象类的作用是什么？什么时候定义抽象类
- 可以被子类继承，充当模板，同时也可以提高代码的复用
- 如果父类知道要完成某个功能，实现要交给子类时

抽象方法是什么样的？
- 只有方法签名，没有方法实体，使用了abstract修饰

继承抽象类有哪些要注意的
- 一个类如果继承了抽象类，要完成抽象类的所有方法
- 否则这个类也必须定义成抽象类
*/
