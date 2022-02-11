package heima_DesignPattern.创建者模式.单例.存在的问题.序列化;

import java.io.Serializable;

/**
 * @version v1.0
 * @ClassName: Singleton
 * @Description: 除了枚举方式之外的都可以，我选择静态内部类
 * @Author: Orange
 **/
public class Singleton implements Serializable {
    private Singleton(){}
    private static class SingletonHolder{
        private static final Singleton INSTANCE = new Singleton();
    }
    public static Singleton getInstance(){
        return SingletonHolder.INSTANCE;
    }
}