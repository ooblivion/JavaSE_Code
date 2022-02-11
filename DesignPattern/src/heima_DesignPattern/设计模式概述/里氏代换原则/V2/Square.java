package heima_DesignPattern.设计模式概述.里氏代换原则.V2;

/**
 * @version v1.0
 * @className: Square
 * @description: 正方形类
 * @author: Orange
 **/
public class Square implements Quadrilateral{
    private double length;
    private double width;

    @Override
    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    @Override
    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }
}
