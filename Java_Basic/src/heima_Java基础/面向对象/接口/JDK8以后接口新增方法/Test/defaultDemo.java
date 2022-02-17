package heima_Java基础.面向对象.接口.JDK8以后接口新增方法.Test;

/**
 * @version v1.0
 * @ClassName: defaultDemo
 * @Description: TODO 类描述
 * @Author: Orange
 **/
interface defaultDemo {
    default void rund() {
        System.out.println("default faster");
    }
}
