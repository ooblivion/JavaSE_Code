package heima_Java基础.面向对象.抽象类.案例;

/**
 * @version v1.0
 * @ClassName: Client
 * @Description:
 *  需求
 *      两种卡，一种是预存1w享受8折的金卡，一种是预存5k享受85折的银卡
 *      分别实现两种卡片进入收银系统后的逻辑，卡片需要包含主人的姓名，余额，支付功能
 *  分析实现
 *      1. 创建父类卡，定义属性包括主人姓名，余额，支付功能（具体实现交给子类
 *      2. 创建金卡类，重写支付功能，按照原价的八折
 *      3. 创建银卡类，重写支付功能，俺早原价的八五折
 * @Author: Orange
 **/
public class Client {
    public static void main(String[] args) {
        GoldCard gc = new GoldCard();
        gc.setMoney(1000);
        gc.setName("orange");
        gc.pay(300);
    }
}
