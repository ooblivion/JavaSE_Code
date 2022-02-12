package heima_DesignPattern.创建者模式.工厂方法.工厂方法模式;

/**
 * @version v1.0
 * @ClassName: AmericanCoffeeFactory
 * @Description: 具体工厂
 * @Author: Orange
 **/
public class AmericanCoffeeFactory implements CoffeeFactory {

    public Coffee createCoffee() {
        return new AmericanCoffee();
    }
}
