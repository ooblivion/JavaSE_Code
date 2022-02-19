package heima_Java基础.面向对象.多态.案例;

/**
 * @version v1.0
 * @ClassName: Client
 * @Description: TODO 类描述
 * @Author: Orange
 **/
public class Client {
    public static void main(String[] args) {
        USB k = new KeyBoard();
        USB m = new KeyBoard();
        Computer c = new Computer();
        c.installUSB(k);
        c.installUSB(m);
    }
}
