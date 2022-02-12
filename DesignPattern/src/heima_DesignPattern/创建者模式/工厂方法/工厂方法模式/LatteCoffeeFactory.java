package heima_DesignPattern.创建者模式.工厂方法.工厂方法模式;

/**
 * @version v1.0
 * @ClassName: LatteCoffeeFactory
 * @Author: Orange
 **/
public class LatteCoffeeFactory implements CoffeeFactory {

    public Coffee createCoffee() {
        return new LatteCoffee();
    }
}
