package heima_DesignPattern.创建者模式.原型.原型模式的实现;

/**
 * @version v1.0
 * @ClassName: Realizetype
 * @Description: TODO 类描述
 * @Author: Orange
 **/
public class Realizetype implements Cloneable {

    public Realizetype() {
        System.out.println("具体的原型对象创建完成！");
    }

    //实现接口后重写clone方法
    @Override
    public Realizetype clone() throws CloneNotSupportedException {
        System.out.println("具体原型复制成功！");

        return (Realizetype) super.clone();
    }
}
