package heima_DesignPattern.设计模式概述.里氏代换原则.V1;

/**
 * @version v1.0
 * @className: RectangleDemo
 * @description: 测试类 正方形不是长方形
 * @author: Orange
 **/
public class RectangleDemo {
    public static void main(String[] args) {
        //创建长方形对象
        Rectangle r = new Rectangle();
        //设置长和宽
        r.setLength(20);
        r.setWidth(10);
        //调用resize方法进行扩宽
        resize(r);
        printLengthAndWidth(r);

        System.out.println("===");

        //创建正方形对象
        Square s = new Square();
        //设置长度
        s.setLength(100);
        //调用resize
        resize(s);
        printLengthAndWidth(s);
    }
    //扩宽方法
    public static void resize(Rectangle rectangle){
        //判断如果宽比长小，进行扩宽操作
        while (rectangle.getWidth() <= rectangle.getLength()){
            rectangle.setWidth(rectangle.getWidth()+1);
        }
    }

    //打印长和宽
    public static void printLengthAndWidth(Rectangle rectangle){
        System.out.println(rectangle.getLength());
        System.out.println(rectangle.getWidth());
    }
}
//就是要将父类当成规范 将长方形扩宽为正方形
//违反该原则可能会出现问题，所以子类尽量不要重写父类方法
