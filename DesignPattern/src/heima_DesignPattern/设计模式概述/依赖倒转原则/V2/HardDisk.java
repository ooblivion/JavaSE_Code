package heima_DesignPattern.设计模式概述.依赖倒转原则.V2;

/**
 * @version v1.0
 * @interfaceName: HardDisk
 * @description: 硬盘接口
 * @author: Orange
 **/
public interface HardDisk {
    public void save(String data);
    public String get();
}
