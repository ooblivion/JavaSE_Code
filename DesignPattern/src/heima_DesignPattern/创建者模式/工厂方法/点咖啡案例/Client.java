package heima_DesignPattern.创建者模式.工厂方法.点咖啡案例;

/**
 * @version v1.0
 * @ClassName: Client
 * @Description: 测试类
 * @Author: Orange
 **/
public class Client {
    public static void main(String[] args) {
        //1,创建咖啡店类
        CoffeeStore store = new CoffeeStore();
        //2,点咖啡
        Coffee coffee = store.orderCoffee("american");

        System.out.println(coffee.getName());
    }
}