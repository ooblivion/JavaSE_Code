package heima_DesignPattern.设计模式概述.接口隔离原则.V2;

/**
 * @version v1.0
 * @className: ADoor
 * @description: A型号安全门对象
 * @author: Orange
 **/
public class ADoor implements DoorFunction_AntiTheft,DoorFunction_FireProof,DoorFunction_WaterProof{
    @Override
    public void antiTheft() {
        System.out.println("a door can anti Theft");
    }

    @Override
    public void fireProof() {
        System.out.println("a door can fire proof");
    }

    @Override
    public void waterProof() {
        System.out.println("a door can water proof");
    }
}
