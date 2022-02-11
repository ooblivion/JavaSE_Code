package heima_DesignPattern.设计模式概述.接口隔离原则.V2;

/**
 * @version v1.0
 * @className: BDoor
 * @description: B型号安全门对象
 * @author: Orange
 **/
public class BDoor implements DoorFunction_WaterProof, DoorFunction_FireProof{
    @Override
    public void fireProof() {
        System.out.println("b door can fire proof");
    }

    @Override
    public void waterProof() {
        System.out.println("b door can water proof");
    }
}
