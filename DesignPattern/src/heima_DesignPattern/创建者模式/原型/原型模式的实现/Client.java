package heima_DesignPattern.创建者模式.原型.原型模式的实现;

/**
 * @version v1.0
 * @ClassName: Client
 * @Description: 测试类
 **/
public class Client {
    public static void main(String[] args) throws CloneNotSupportedException{
        //创建一个原型类对象
        Realizetype realizetype = new Realizetype();

        //复制的时候不会执行构造方法，说明底层不是通过new对象的方法来实现的深克隆是返回统一对象，浅克隆是克隆出一个对象
        Realizetype clone = realizetype.clone();

        System.out.println("原型和克隆出来的是否是同一个对象？" + (realizetype == clone));//false
    }
}
