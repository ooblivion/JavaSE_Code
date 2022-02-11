package heima_DesignPattern.创建者模式.单例.懒汉式.双重检查锁.V2_volatitle;

/**
 * @version v1.0
 * @ClassName: Singleton
 * @Description: TODO 类描述
 * @Author: Orange
 **/
public class Singleton {

    //私有构造方法
    private Singleton() {}

    private static volatile Singleton instance;

    //对外提供静态方法获取该对象
    public static Singleton getInstance() {
        //第一次判断，如果instance不为null，不进入抢锁阶段，直接返回实际
        if(instance == null) {
            synchronized (Singleton.class) {
                //抢到锁之后再次判断是否为空
                if(instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}

/**
 * 添加 `volatile` 关键字之后的双重检查锁模式是一种比较好的单例实现模式，能够保证在多线程的情况下线程安全也不会有性能问题
 **/

