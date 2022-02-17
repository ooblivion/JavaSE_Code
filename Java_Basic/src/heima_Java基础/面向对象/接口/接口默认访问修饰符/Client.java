package heima_Java基础.面向对象.接口.接口默认访问修饰符;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @version v1.0
 * @ClassName: Client
 * @Description: TODO 类描述
 * @Author: Orange
 **/

//Java中Interface方法默认访问修饰符为：public abstract
//Java中Interface常量的默认访问修饰符为：public static final
//验证方式：反射

public class Client {
    public static void main(String[] args) {
        test();
    }

    public static void test(){
        Class c = SomeService.class;
        Method[] methods = c.getDeclaredMethods();
        for(Method m : methods){
            System.out.println(m);
        }

        System.out.println("===");

        Field[] fields = c.getFields();
        for (Field f : fields){
            System.out.println(f);
        }

        //public abstract void heima_Java基础.面向对象.接口.接口默认访问修饰符.SomeService.save(java.lang.Object)
        //public default java.lang.String heima_Java基础.面向对象.接口.接口默认访问修饰符.SomeService.des()
        //public static final java.lang.String heima_Java基础.面向对象.接口.接口默认访问修饰符.SomeService.hi
    }
}

interface SomeService{
    String hi = "hello world";

    void save(Object obj);

    //return string
    default String des(){
        return hi;
    }
}
