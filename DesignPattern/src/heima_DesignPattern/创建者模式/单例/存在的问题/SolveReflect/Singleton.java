package heima_DesignPattern.创建者模式.单例.存在的问题.SolveReflect;

/**
 * @version v1.0
 * @ClassName: Singleton
 * @Description: TODO 类描述
 * @Author: Orange
 **/
public class Singleton {

    //私有构造方法
    private Singleton() {
        /*
           反射破解单例模式需要添加的代码
        */
        if(instance != null) {
            throw new RuntimeException("不能创建多个对象");
        }
    }

    private static volatile Singleton instance;

    //对外提供静态方法获取该对象
    public static Singleton getInstance() {

        if(instance != null) {
            return instance;
        }

        synchronized (Singleton.class) {
            if(instance != null) {
                return instance;
            }
            instance = new Singleton();
            return instance;
        }
    }
}
