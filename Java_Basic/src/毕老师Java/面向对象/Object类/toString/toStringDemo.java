package 毕老师Java.面向对象.Object类.toString;

/**
 * @version v1.0
 * @ClassName: toStringDemo
 * @Description: TODO 类描述
 * @Author: Orange
 **/
public class toStringDemo {
    public static void main(String[] args) {
        Demo d1 = new Demo(1);
        Demo d2 = new Demo(9);
        //由于所有的对象都由地址，所以获取地址定义到了Object中
        System.out.println(d1.toString());//默认十六进制 day5.Demo@1b6d3586 类名@哈希值
        System.out.println("默认10进制："+d1.hashCode()+" /// 16进制："+Integer.toHexString(d1.hashCode()));
        System.out.println(d2.toString());
        System.out.println("===");
        System.out.println(d1.getClass());//较为特殊，返回一个class类型的文件：class day5.Demo

        //类的类？类比c中的双重指针
        System.out.println("===");
        Class c = d1.getClass();
        System.out.println(c.getName());
        System.out.println(c.getName() + "@@" + Integer.toHexString(d1.hashCode()));
        System.out.println(c.getClass());
        System.out.println();

        //toString可以理解为getClass+Integer.toHexString(hashCode)

        System.out.println("===");
        //每个对象都有不同的字符串表现形式
        System.out.println(d1.toString());//1
        System.out.println(d2.toString());//9
    }
}

/*
A.class === new A()
B.class === new B()
class文件都有名词，这些文件内部都有构造函数、一般方法、成员变量

Class来描述这些class文件

抽象的抽象
 */
