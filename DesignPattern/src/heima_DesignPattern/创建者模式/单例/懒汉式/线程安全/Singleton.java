package heima_DesignPattern.创建者模式.单例.懒汉式.线程安全;

/**
 * @version v1.0
 * @ClassName: Singleton
 * @Description: TODO 类描述
 * @Author: Orange
 **/
public class Singleton {
    //私有构造方法
    private Singleton() {}

    //在成员位置创建该类的对象
    private static Singleton instance;

    //对外提供静态方法获取该对象
    public static synchronized Singleton getInstance() {

        if(instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}

/*
* 该方式也实现了懒加载效果，同时又解决了线程安全问题。
* 但是在getInstance()方法上添加了synchronized关键字，导致该方法的执行效果特别低。
* 从上面代码我们可以看出，其实就是在初始化instance的时候才会出现线程安全问题，一旦初始化完成就不存在了。
* */