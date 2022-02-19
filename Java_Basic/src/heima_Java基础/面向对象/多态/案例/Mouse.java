package heima_Java基础.面向对象.多态.案例;

/**
 * @version v1.0
 * @ClassName: Mouse
 * @Description: TODO 类描述
 * @Author: Orange
 **/
public class Mouse implements USB{
    @Override
    public void output() {
        System.out.println("mouse out put");
    }

    @Override
    public void input() {
        System.out.println("mouse input");
    }

    public void click(){
        System.out.println("mouse click");
    }
}
