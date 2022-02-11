package heima_DesignPattern.设计模式概述.依赖倒转原则.V2;

/**
 * @version v1.0
 * @className: XiJieHardDisk
 * @description: TODO 类描述
 * @author: Orange
 **/
public class XiJieHardDisk implements HardDisk{

    /**
     * 存储数据的方法
     */
    @Override
    public void save(String data){
        System.out.println("使用希捷硬盘存储数据为：" + data);
    }

    /**
     * 获取数据的方法
     */
    @Override
    public String get(){
        System.out.println("使用希捷硬盘取数据");
        return "数据";
    }
}
