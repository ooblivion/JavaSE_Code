package heima_DesignPattern.创建者模式.单例.饿汉式.静态代码块;

/**
 * @version v1.0
 * @className: Singleton
 * @description: 饿汉式 在静态代码块中创建该类对象
 * @author: Orange
 **/
public class Singleton {

    //私有构造方法
    private Singleton() {}

    //在成员位置创建该类的对象
    private static Singleton instance;

    static {
        instance = new Singleton();
    }

    //对外提供静态方法获取该对象
    public static Singleton getInstance() {
        return instance;
    }
}

