package heima_Java基础.面向对象.抽象类.案例;

/**
 * @version v1.0
 * @ClassName: Card
 * @Description: TODO 类描述
 * @Author: Orange
 **/
public abstract class Card {
    private String name;
    private double money;

    public abstract void pay(double money);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
}
