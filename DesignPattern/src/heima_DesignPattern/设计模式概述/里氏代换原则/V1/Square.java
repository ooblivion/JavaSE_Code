package heima_DesignPattern.设计模式概述.里氏代换原则.V1;

/**
 * @version v1.0
 * @className: Square
 * @description: 正方形类
 * @author: Orange
 **/
public class Square extends Rectangle{

    //正方形长宽相同
    @Override
    public void setLength(double length) {
        super.setLength(length);
        super.setWidth(length);
    }

    @Override
    public void setWidth(double width) {
        super.setWidth(width);
        super.setLength(width);
    }
}
