package heima_DesignPattern.创建者模式.工厂方法.简单工厂模式;

/**
 * @version v1.0
 * @ClassName: CoffeeStore
 * @Description: 咖啡店类
 * @Author: Orange
 **/
public class CoffeeStore {

    public Coffee orderCoffee(String type) {

        SimpleCoffeeFactory factory = new SimpleCoffeeFactory();
        //调用生产咖啡的方法
        Coffee coffee = factory.createCoffee(type);

        //加配料
        coffee.addMilk();
        coffee.addSugar();

        return coffee;
    }
}

