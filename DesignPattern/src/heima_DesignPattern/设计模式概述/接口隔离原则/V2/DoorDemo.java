package heima_DesignPattern.设计模式概述.接口隔离原则.V2;

/**
 * @version v1.0
 * @className: DoorDemo
 * @description: 改进后的测试类
 * @author: Orange
 **/
public class DoorDemo {
    public static void main(String[] args) {
        ADoor a = new ADoor();
        BDoor b = new BDoor();

        a.antiTheft();
        a.fireProof();
        a.waterProof();

        b.fireProof();
        b.waterProof();
    }
}
