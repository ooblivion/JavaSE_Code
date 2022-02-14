package 毕老师Java.面向对象.继承;

/**
 * @version v1.0
 * @ClassName: extendDemo
 * @Description: TODO 类描述
 * @Author: Orange
 **/
public class extendDemo {
    public static void main(String[] args) {
        System.out.println("hello");
    }
}

class Student{
    String name;
    int age;
    void study(){
        System.out.println("study");
    }
}
class Worker{
    String name;
    int age;
    void work(){
        System.out.println("work");
    }
}

//class Worker extends Student

//千万不要为了获取其他类的功能、简化代码而继承，必须是类与类之间有所属关系才可以继承，所属关系 is a。