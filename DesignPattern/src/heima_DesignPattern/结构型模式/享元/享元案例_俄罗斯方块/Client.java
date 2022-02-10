package heima_DesignPattern.结构型模式.享元.享元案例_俄罗斯方块;

/**
 * @version v1.0
 * @className: Client
 * @author: Orange
 **/
public class Client {
    public static void main(String[] args) {
        //获取I图形对象
        AbstractBox box1 = BoxFactory.getInstance().getShape("I");
        box1.display("灰色");

        //获取L图形对象
        AbstractBox box2 = BoxFactory.getInstance().getShape("Z");
        box2.display("红色");

        //获取o图形对象
        AbstractBox box3 = BoxFactory.getInstance().getShape("O");
        box3.display("蓝色");

        //获取o图形对象
        AbstractBox box4 = BoxFactory.getInstance().getShape("O");
        box4.display("黑色");

        System.out.println("box3 == box4 ? " + (box3 == box4));
    }
}
