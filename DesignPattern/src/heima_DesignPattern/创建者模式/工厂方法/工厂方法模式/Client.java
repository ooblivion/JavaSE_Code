package heima_DesignPattern.创建者模式.工厂方法.工厂方法模式;

/**
 * @version v1.0
 * @ClassName: Client
 * @Description: 测试类
 * @Author: Orange
 **/
public class Client {
    public static void main(String[] args) {
        //创建咖啡店对象
        CoffeeStore store = new CoffeeStore();
        //创建对象
        //CoffeeFactory factory = new AmericanCoffeeFactory();
        CoffeeFactory factory = new LatteCoffeeFactory();
        store.setFactory(factory);

        //点咖啡
        Coffee coffee = store.orderCoffee();

        System.out.println(coffee.getName());
    }
}
