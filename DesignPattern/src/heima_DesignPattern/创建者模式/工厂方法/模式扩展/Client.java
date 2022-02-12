package heima_DesignPattern.创建者模式.工厂方法.模式扩展;

/**
 * @version v1.0
 * @ClassName: Client
 * @Description: 测试类
 * @Author: Orange
 **/
public class Client {
    public static void main(String[] args) {
        Coffee coffee = CoffeeFactory.createCoffee("american");
        System.out.println(coffee);
    }
}
