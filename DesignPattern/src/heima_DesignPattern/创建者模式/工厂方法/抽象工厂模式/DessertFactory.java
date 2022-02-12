package heima_DesignPattern.创建者模式.工厂方法.抽象工厂模式;

/**
 * @version v1.0
 * @InterfaceName: DessertFactory
 * @Description: TODO 类描述
 * @Author: Orange
 **/
public interface DessertFactory {

    Coffee createCoffee();

    Dessert createDessert();
}
