package heima_Java基础.常量;

/**
 * @version v1.0
 * @ClassName: final_demo
 * @Description: TODO 类描述
 * @Author: Orange
 **/
public class final_demo {
    public static final String name1 = "aaa";
    public static final String name2;
    static{
        name2 = "bbb";
    }

    //实例成员变量
    private final String name = "ccc";

    public static void main(String[] args) {
        /*
        变量有几种？
        - 局部变量
        - 成员变量
            - 静态成员变量
            - 实例成员变量
        final修饰类不能被继承，修饰方法不能被重写，修饰局部变量只能赋值一次

        如果是静态成员变量被final修饰后，可以初始化赋值，也可以静态代码块赋值

        实例成员变量一般不用final修饰

        final修饰基本类型的变量时候，数据值不能改变，修饰引用类型，地址值不能改变，但是地址指向的对象的内容可以改变
        比如final是一个地址，这个地址是一个停车场，这个停车场里面可以有本田，也可以有宝马
         */
        int age;
        final int www;
        www = 11;
        //www = 12;
    }
}
