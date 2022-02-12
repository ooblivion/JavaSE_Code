package heima_DesignPattern.创建者模式.工厂方法.简单工厂模式;

/**
 * @version v1.0
 * @ClassName: SimpleCoffeeFactory_Static
 * @Description:
 *  静态工厂 将创建对象的功能定义为静态的
 *  好处：外卖类 从工厂获取咖啡对象 不需要创建工厂对象，可以直接通过类名调用
 *  工厂是重量级对象，只创建一份即可
 * @Author: Orange
 **/
public class SimpleCoffeeFactory_Static {

    public static Coffee createCoffee(String type) {
        Coffee coffee = null;
        if("americano".equals(type)) {
            coffee = new AmericanCoffee();
        } else if("latte".equals(type)) {
            coffee = new LatteCoffee();
        }
        return coffee;
    }
}