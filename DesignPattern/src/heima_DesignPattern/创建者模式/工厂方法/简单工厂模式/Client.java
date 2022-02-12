package heima_DesignPattern.创建者模式.工厂方法.简单工厂模式;

/**
 * @version v1.0
 * @ClassName: Client
 * @Description: 测试类
 * @Author: Orange
 **/
public class Client {
    public static void main(String[] args) {
        //创建咖啡店类对象
        CoffeeStore store = new CoffeeStore();
        Coffee coffee = store.orderCoffee("latte");

        System.out.println(coffee.getName());
    }
}
