package heima_DesignPattern.创建者模式.单例.饿汉式.静态变量;

/**
 * @version v1.0
 * @className: Client
 * @description: TODO 类描述
 * @author: Orange
 **/
public class Client {
    public static void main(String[] args) {
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));
    }
}
