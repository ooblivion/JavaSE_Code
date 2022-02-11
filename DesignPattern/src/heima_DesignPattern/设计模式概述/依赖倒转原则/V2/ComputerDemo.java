package heima_DesignPattern.设计模式概述.依赖倒转原则.V2;

/**
 * @version v1.0
 * @className: ComputerDemo
 * @description: TODO 类描述
 * @author: Orange
 **/
public class ComputerDemo {
    public static void main(String[] args) {
        //创建计算机的组件对象
        HardDisk XiJie = new XiJieHardDisk();
        Cpu intel = new IntelCpu();
        KingstonMemory kingstonMemory = new KingstonMemory();

        //创建计算机对象
        Computer computer = new Computer();

        //组装计算机
        computer.setCpu(intel);
        computer.setMemory(kingstonMemory);
        computer.setHardDisk(XiJie);
        computer.run();
    }
}
