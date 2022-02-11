package heima_DesignPattern.设计模式概述.接口隔离原则.V1;

/**
 * @version v1.0
 * @className: ADoor
 * @description: A型号安全门对象
 * @author: Orange
 **/
public class ADoor implements SafeDoor{
    @Override
    public void antiTheft() {
        System.out.println("door can anti theft");
    }

    @Override
    public void fireProof() {
        System.out.println("door can fire proof");
    }

    @Override
    public void waterProof() {
        System.out.println("door can water proof");
    }
}
