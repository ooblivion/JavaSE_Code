package heima_DesignPattern.创建者模式.工厂方法.点咖啡案例;

/**
 * @version v1.0
 * @ClassName: Coffee
 * @Description: 咖啡类
 * @Author: Orange
 **/
public abstract class Coffee {

    public abstract String getName();

    //加糖
    public void addSugar() {
        System.out.println("加糖");
    }

    //加奶
    public void addMilk() {
        System.out.println("加奶");
    }
}
