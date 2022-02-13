package heima_DesignPattern.创建者模式.建造者.创建共享单车;

/**
 * @version v1.0
 * @ClassName: Builder
 * @Description: TODO 类描述
 * @Author: Orange
 **/
public abstract class Builder {

    //声明Bike类型的变量，并进行赋值
    protected Bike bike = new Bike();

    public abstract void buildFrame();

    public abstract void buildSeat();

    //构建自行车的方法
    public abstract Bike createBike();
}