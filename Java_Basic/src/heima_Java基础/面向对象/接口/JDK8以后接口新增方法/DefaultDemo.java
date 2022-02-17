package heima_Java基础.面向对象.接口.JDK8以后接口新增方法;

/**
 * @version v1.0
 * @ClassName: DefaultDemo
 * @Description: JDK1.8新增方法
 * @Author: Orange
 **/
//需要用接口的实现类对象来调用
public interface DefaultDemo {
    default void run(){
        System.out.println("run run run");
    }
}
