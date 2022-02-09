package heima_DesignPattern.设计模式概述.开闭原则;

/**
 * @version v1.0
 * @className: Client
 * @description: 测试类
 * @author: Orange
 **/
public class Client {
    public static void main(String[] args) {
        //1.创建搜狗输入法对象
        SougouInput sougouInput = new SougouInput();

        //2.创建皮肤对象
        DefaultSkin defaultSkin = new DefaultSkin();
        //ColourfulSkin colourfulSkin = new ColourfulSkin();

        //3.将皮肤对象设置到输入法中
        sougouInput.setSkin(defaultSkin);
        //sougouInput.setSkin(colourfulSkin);

        //4.显示皮肤
        sougouInput.display();
    }
}

