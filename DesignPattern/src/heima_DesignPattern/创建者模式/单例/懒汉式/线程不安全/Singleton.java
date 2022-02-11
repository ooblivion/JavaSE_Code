package heima_DesignPattern.创建者模式.单例.懒汉式.线程不安全;

/**
 * @version v1.0
 * @className: Singleton
 * @description: TODO 类描述
 * @author: Orange
 **/
public class Singleton {
    //私有构造方法
    private Singleton() {}

    //在成员位置创建该类的对象
    private static Singleton instance;

    //对外提供静态方法获取该对象
    public static Singleton getInstance() {
        //判断一下，如果有的话直接返回，没有就创建一个
        if(instance == null) {
            //线程1等待，线程2获取到cpu的执行权，也会进入到该判断里面
            instance = new Singleton();
        }
        return instance;
    }
}
