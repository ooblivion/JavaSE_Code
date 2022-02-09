package heima_DesignPattern.设计模式概述.开闭原则;

/**
 * @version v1.0
 * @className: SougouInput
 * @description: 搜狗输入法 代理模式
 * @author: Orange
 **/
public class SougouInput {
    //聚合
    private AbstractSkin skin;
    public void setSkin(AbstractSkin skin){
        this.skin = skin;
    }

    public void display(){
        skin.display();
    }
}
