package heima_DesignPattern.创建者模式.单例.懒汉式.静态内部类.反射攻击;

import heima_DesignPattern.创建者模式.单例.懒汉式.静态内部类.Singleton;

import java.lang.reflect.Constructor;

/**
 * @version v1.0
 * @ClassName: Problem
 * @Description: 反射攻击
 **/
public class Problem {
    public static void main(String[] args) throws Exception {
        Singleton singleton = Singleton.getInstance();
        Constructor<Singleton> constructor = Singleton.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        Singleton newSingleton = constructor.newInstance();
        //通过结果看，这两个实例不是同一个，这就违背了单例模式的原则
        System.out.println(singleton == newSingleton);//false
    }
}
