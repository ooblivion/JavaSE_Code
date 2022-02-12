package heima_DesignPattern.创建者模式.工厂方法.工厂方法模式;

/**
 * @version v1.0
 * @ClassName: CoffeeStore
 * @Description: 咖啡店类
 * @Author: Orange
 **/
public class CoffeeStore {

    private CoffeeFactory factory;

    public void setFactory(CoffeeFactory factory) {
        this.factory = factory;
    }

    //点咖啡功能
    public Coffee orderCoffee() {
        Coffee coffee = factory.createCoffee();
        //加配料
        coffee.addMilk();
        coffee.addSugar();
        return coffee;
    }
}
