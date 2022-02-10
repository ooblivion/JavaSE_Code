package heima_DesignPattern.结构型模式.享元.享元案例_俄罗斯方块;

/**
 * @version v1.0
 * @className: AbstractBox
 * @description: 抽象享元角色
 * @author: Orange
 **/
public abstract class AbstractBox {
    //获取图形的方法
    public abstract String getShape();
    //显示图形以及颜色
    public void display(String color){
        System.out.println("方块形状："+ getShape()+"，颜色："+color);
    }
}
