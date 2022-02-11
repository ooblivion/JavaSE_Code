package heima_DesignPattern.创建者模式.单例.懒汉式.双重检查锁.V1;

/**
 * @version v1.0
 * @ClassName: Singleton
 * @Description: TODO 类描述
 * @Author: Orange
 **/
public class Singleton {

    //私有构造方法
    private Singleton() {}

    private static Singleton instance;

    //对外提供静态方法获取该对象
    public static Singleton getInstance() {
        //第一次判断，如果instance不为null，不进入抢锁阶段，直接返回实例
        if(instance == null) {
            synchronized (Singleton.class) {
                //抢到锁之后再次判断是否为null
                if(instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
/*
* 在多线程的情况下，可能会出现空指针问题，出现问题的原因是JVM在实例化对象的时候会进行优化和指令重排序操作。
*/