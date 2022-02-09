package heima_DesignPattern.设计模式概述.开闭原则;

/**
 * @version v1.0
 * @className: DefaultSkin
 * @description: 默认皮肤类
 * @author: Orange
 **/
public class DefaultSkin extends AbstractSkin{
    @Override
    public void display() {
        System.out.println("默认皮肤");
    }
}
