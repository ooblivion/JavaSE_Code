package heima_Java基础.面向对象.多态.概述;

/**
 * @version v1.0
 * @ClassName: Demo
 * @Description: TODO 类描述
 * @Author: Orange
 **/
//多态的定义：同类型对象，执行同一个行为会表现处不同的特征
//多态中成员访问特点
//  方法调用：编译看左边，运行看右边
//  变量调用：编译看左边，运行也看左边。多态侧重行为多态，面试常问
public class Demo {
    public static void main(String[] args) {
        Animal a1 = new Dog();
        Animal a2 = new Tortoise();

        a1.run();//方法调用：编译看左边，运行看右边
        a2.run();

        System.out.println(a1.name);//变量调用：编译看左边，运行也看左边。多态侧重行为多态，面试常问
        System.out.println(a2.name);
    }
}


