package heima_Java基础.面向对象.接口.JDK8以后接口新增方法;

/**
 * @version v1.0
 * @InterfaceName: PrivateDemo
 * @Description: JDK1.9新增方法
 * @Author: Orange
 **/
//只能在本类中被其他的默认方法或者私有方法调用
public interface PrivateDemo {
    private void go(){
        System.out.println("run run run ");
    }
}
