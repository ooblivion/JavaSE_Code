package heima_DesignPattern.创建者模式.单例.存在的问题.反射;

import java.lang.reflect.Constructor;

/**
 * @version v1.0
 * @ClassName: Client
 * @Description: TODO 类描述
 * @Author: Orange
 **/
public class Client {
    public static void main(String[] args) throws Exception{
        //获取Singleton的字节码对象
        //Class<Singleton> c1 = Singleton.class;
        Class c1 = Singleton.class;

        //获取无参构造方法对象
        Constructor cons = c1.getDeclaredConstructor();//NoSuchMethodException
        //取消访问呢检查
        cons.setAccessible(true);
        //创建Singleton对象
        Singleton s1 = (Singleton) cons.newInstance();
        Singleton s2 = (Singleton) cons.newInstance();
        System.out.println(s1 == s2);
    }
}
