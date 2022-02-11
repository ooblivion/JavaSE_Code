package heima_DesignPattern.设计模式概述.里氏代换原则.V2;

/**
 * @version v1.0
 * @className: RectangleDemo
 * @description: 测试类
 * @author: Orange
 **/
public class RectangleDemo {
    public static void main(String[] args) {
        Rectangle r = new Rectangle();
        r.setLength(20);
        r.setWidth(10);
        resize(r);
        printLengthAndWidth(r);

        System.out.println("===");

        Square s = new Square();
        s.setLength(100);
        s.setWidth(100);
        //resize(s);
        printLengthAndWidth(s);
    }

    //扩宽的方法
    public static void resize(Rectangle rectangle){
        //判断如果宽比长小，进行扩宽操作
        while (rectangle.getWidth() <= rectangle.getLength()){
            rectangle.setWidth(rectangle.getWidth()+1);
        }
    }

    //打印长和宽
    public static void printLengthAndWidth(Quadrilateral quadrilateral){
        System.out.println(quadrilateral.getLength());
        System.out.println(quadrilateral.getWidth());
    }
}
