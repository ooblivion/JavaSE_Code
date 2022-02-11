package heima_DesignPattern.创建者模式.单例.饿汉式.枚举;

/**
 * @version v1.0
 * @ClassName: Singleton
 * @Description: TODO 类描述
 * @Author: Orange
 **/
public enum Singleton {
    //其实就是饿汉式下的
    //private final static Sinleton singleton = new Singleton
    INSTANCE;

    public void doSomething() {
        System.out.println("doSomething");
    }
}
/*
* 在effective java（这本书真的很棒）中说道，最佳的单例实现模式就是枚举模式。
* 利用枚举的特性，让JVM来帮我们保证线程安全和单一实例的问题。
* 除此之外，写法还特别简单。
* */
