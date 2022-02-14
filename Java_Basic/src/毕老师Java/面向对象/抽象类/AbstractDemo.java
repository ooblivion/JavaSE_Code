package 毕老师Java.面向对象.抽象类;

/**
 * @version v1.0
 * @ClassName: AbstractDemo
 * @Description: TODO 类描述
 * @Author: Orange
 **/
public class AbstractDemo {
    public static void main(String[] args) {
        System.out.println("hello");
        BaseStudent b1 = new BaseStudent();
        b1.study();
        b1.another();
        b1.eat();
    }
}

//抽象方法必须存在于抽象类中，告诉主函数不能创建抽象类的对象，不能创建一个看不懂的对象
abstract class Student{
//    void study{
//        System.out.println("study");
//    }
//    abstract void study();
    abstract void study();
    abstract void another();
    void eat(){
        System.out.println("i can eat");//抽象类当中既可以由一般方法也可以有抽象方法
    }
}

//基础学习
//实现了抽象父类中的所有抽象方法，所以不是抽象类
class BaseStudent extends Student{
    void study(){
        System.out.println("base study");
    }
    void another(){
        System.out.println("another");
    }
}

//进阶学习
//由于没有实现所有的抽象类，所以还是一个抽象类
abstract class AdvStudent extends Student{
    void study(){
        System.out.println("advance study");
    }
}
