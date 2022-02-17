package heima_Java基础.面向对象.抽象类.模板方法模式.V2;

/**
 * @version v1.0
 * @ClassName: Client
 * @Description: TODO 类描述
 * @Author: Orange
 **/
public class Client {
    public static void main(String[] args) {
        Account a1 = new CurrentAccount("ICBC-111", 100001);
        a1.handle("orange", "123456");
        //本账户利息：350.00350000000003
        //如何计算精确值？BigDecimal
    }
}
