package heima_DesignPattern.设计模式概述.依赖倒转原则.V1;

/**
 * @version v1.0
 * @className: TestComputer
 * @description: 测试类用来组装电脑
 * @author: Orange
 **/
public class TestComputer {
    public static void main(String[] args) {
        Computer computer = new Computer();
        computer.setHardDisk(new XiJieHardDisk());
        computer.setCpu(new IntelCpu());
        computer.setMemory(new KingstonMemory());

        computer.run();
    }
}
