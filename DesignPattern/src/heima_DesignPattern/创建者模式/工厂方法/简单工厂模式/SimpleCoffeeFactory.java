package heima_DesignPattern.创建者模式.工厂方法.简单工厂模式;

/**
 * @version v1.0
 * @ClassName: SimpleCoffeeFactory
 * @Description: 简单咖啡工厂类，用来生产咖啡
 * @Author: Orange
 **/
public class SimpleCoffeeFactory {

    public Coffee createCoffee(String type) {
        //声明Coffee类型的变量，根据不同类型创建不同的coffee子类对象
        Coffee coffee = null;
        if("american".equals(type)) {
            coffee = new AmericanCoffee();
        } else if("latte".equals(type)) {
            coffee = new LatteCoffee();
        } else {
            throw new RuntimeException("对不起，您所点的咖啡没有");
        }

        return coffee;
    }
}
//简单来说就是工厂模式提供了批量修改的方法
//只需要在工厂类里面修改即可，带来了工厂和咖啡的耦合（但还是解决了一定问题
