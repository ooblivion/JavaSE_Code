package heima_DesignPattern.设计模式概述.开闭原则;

/**
 * @version v1.0
 * @className: ColourfulSkin
 * @description: 炫彩皮肤类
 * @author: Orange
 **/
public class ColourfulSkin extends AbstractSkin{
    @Override
    public void display() {
        System.out.println("炫彩皮肤");
    }
}
