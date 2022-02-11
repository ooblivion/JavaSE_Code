package heima_DesignPattern.创建者模式.单例.懒汉式.静态内部类;

/**
 * @version v1.0
 * @ClassName: Singleton
 * @Description: TODO 类描述
 * @Author: Orange
 **/
public class Singleton {

    //私有构造方法
    private Singleton() {}

    //定义一个静态内部类
    private static class SingletonHolder {
        //在内部内中声明并初始化外部类的对象
        private static final Singleton INSTANCE = new Singleton();
    }

    //对外提供静态方法获取该对象，提供公共的访问方式
    public static Singleton getInstance() {
        return SingletonHolder.INSTANCE;
    }
}