package heima_DesignPattern.创建者模式.单例.存在的问题.tempReflect;

/**
 * @version v1.0
 * @ClassName: Singleton
 * @Description: TODO 类描述
 * @Author: Orange
 **/
public class Singleton {
    private static boolean flag = false;

    //私有构造方法
    private Singleton(){
        synchronized (Singleton.class){
            if (flag){
                throw new RuntimeException("不能创建多个对象");
            }
            //将flag设置为true
            flag = true;
        }
    }

    private static class SingletonHolder{
        private static final Singleton INSTANCE = new Singleton();
    }

    public static Singleton getInstance(){
        return SingletonHolder.INSTANCE;
    }
}
