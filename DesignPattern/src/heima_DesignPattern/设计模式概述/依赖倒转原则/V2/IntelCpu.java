package heima_DesignPattern.设计模式概述.依赖倒转原则.V2;

/**
 * @version v1.0
 * @className: IntelCpu
 * @description: 英特尔cpu
 * @author: Orange
 **/
public class IntelCpu implements Cpu{

    @Override
    public void run(){
        System.out.println("使用Intel处理器");
    }
}