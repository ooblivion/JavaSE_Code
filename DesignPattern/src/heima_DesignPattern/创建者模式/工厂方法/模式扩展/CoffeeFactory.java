package heima_DesignPattern.创建者模式.工厂方法.模式扩展;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * @version v1.0
 * @ClassName: CoffeeFactory
 * @Description:
 *  有点像Spring中的bean原理，Spring更复杂，涉及到了注入&依赖
 *  其实根据业务逻辑应该缓存class，不然客户都喝的同一杯咖啡
 *  上面的一大串都是为了凑反射创建对象，把配置文件里面的类全部加载到map中
 *  这基本就是Spring的IOC源码！！！
 * @Author: Orange
 **/
public class CoffeeFactory {

    //加载配置文件，获取配置文件中配置的全类名，并创建该类的对象进行存储
    //1.定义容器对象存储咖啡对象
    private static Map<String,Coffee> map = new HashMap();

    //2.加载配置文件，只需要加载一次，所以放在静态代码块中
    static {
        //2.1 创建Properties对象
        Properties p = new Properties();
        //2.2 调用p对象中的load方法进行配置文件的加载
        InputStream is = CoffeeFactory.class.getClassLoader().getResourceAsStream("bean.properties");
        try {
            p.load(is);
            //遍历Properties集合对象，从p集合中获取全类名并创建对象
            Set<Object> keys = p.keySet();
            for (Object key : keys) {
                //根据键获取值（全类名）
                String className = p.getProperty((String) key);
                //获取字节码对象，通过反射技术创建对象
                Class clazz = Class.forName(className);
                Coffee obj = (Coffee) clazz.newInstance();
                //将名称和对象存储到容器中
                map.put((String)key,obj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Coffee createCoffee(String name) {

        return map.get(name);
    }
}
//静态块里面就创建了两个对象，其他地方都没有创建，算是单例