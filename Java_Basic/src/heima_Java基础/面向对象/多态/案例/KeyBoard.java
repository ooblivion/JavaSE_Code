package heima_Java基础.面向对象.多态.案例;

/**
 * @version v1.0
 * @ClassName: KeyBoard
 * @Description: TODO 类描述
 * @Author: Orange
 **/
public class KeyBoard implements USB{
    @Override
    public void output() {
        System.out.println("key out put");
    }

    @Override
    public void input() {
        System.out.println("key input");
    }

    public void write(){
        System.out.println("key write");
    }

}
