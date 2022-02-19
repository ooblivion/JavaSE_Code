package heima_Java基础.面向对象.多态.优点;

/**
 * @version v1.0
 * @ClassName: Demo
 * @Description: TODO 类描述
 * @Author: Orange
 **/

//定义方法的时候使用父类型做参数，体现出多态的便利性
//在多态模式下，右边对象可以实现解耦合，便于维护和拓展
//定义方法的时候，使用父类型作为参数，该方法就可以接收这父类的一切子类对象，体现处出多态的扩展性与便利

//缺点：无法使用子类独有的功能，编译阶段报错
public class Demo {
    public static void main(String[] args) {
        Tortoise t = new Tortoise();
        Dog d = new Dog();

        go(t);
        go(d);
    }
    public static void go(Animal a){
        System.out.println("begin");
        a.run();
        System.out.println("end");
    }
}
