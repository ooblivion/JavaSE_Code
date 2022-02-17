package heima_Java基础.面向对象.接口.JDK8以后接口新增方法.Test;

/**
 * @version v1.0
 * @ClassName: privateDemo
 * @Description: TODO 类描述
 * @Author: Orange
 **/ //内部其他方法或私有方法调用
interface privateDemo {
    private void runp() {
        System.out.println("private run");
    }

    default void another() {
        System.out.println("another");
        runp();
    }
}
