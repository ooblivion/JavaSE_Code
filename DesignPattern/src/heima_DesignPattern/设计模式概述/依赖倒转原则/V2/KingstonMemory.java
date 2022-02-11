package heima_DesignPattern.设计模式概述.依赖倒转原则.V2;

/**
 * @version v1.0
 * @className: KingstonMemory
 * @description: 金士顿内存条
 * @author: Orange
 **/
public class KingstonMemory implements Memory{

    @Override
    public void save() {
        System.out.println("使用金士顿内存条");
    }
}
