package heima_DesignPattern.创建者模式.工厂方法.抽象工厂模式;

/**
 * @version v1.0
 * @ClassName: ItalyDessertFactory
 * @Description: TODO 类描述
 * @Author: Orange
 **/
public class ItalyDessertFactory implements DessertFactory {

    public Coffee createCoffee() {
        return new LatteCoffee();
    }

    public Dessert createDessert() {
        return new Tiramisu();
    }
}
