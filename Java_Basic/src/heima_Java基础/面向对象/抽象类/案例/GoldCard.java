package heima_Java基础.面向对象.抽象类.案例;

/**
 * @version v1.0
 * @ClassName: GoldCard
 * @Description: TODO 类描述
 * @Author: Orange
 **/
public class GoldCard extends Card{
    @Override
    public void pay(double money) {
        //优惠后的金额计算出来
        double realPay = money*0.8;
        double lastMoney = getMoney() - realPay;
        System.out.println(getName() +
                "当前账户总金额：" + getMoney() +
                "，当前消费了：" + realPay +
                ". 消费后剩余：" + lastMoney
        );
        setMoney(lastMoney);
    }
}
