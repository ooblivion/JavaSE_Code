package heima_Java基础.面向对象.多态.优点;

/**
 * @version v1.0
 * @ClassName: Dog
 * @Description: TODO 类描述
 * @Author: Orange
 **/
public class Dog extends Animal{
    public String name = "子类狗";
    @Override
    public void run() {
        System.out.println("dog run quick");
    }
}
