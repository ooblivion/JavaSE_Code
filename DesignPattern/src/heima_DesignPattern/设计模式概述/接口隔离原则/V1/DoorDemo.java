package heima_DesignPattern.设计模式概述.接口隔离原则.V1;

/**
 * @version v1.0
 * @className: DoorDemo
 * @description: 测试类
 * @author: Orange
 **/
public class DoorDemo {
    public static void main(String[] args) {
        ADoor aDoor = new ADoor();
        aDoor.antiTheft();
        aDoor.fireProof();
        aDoor.waterProof();
    }
}
