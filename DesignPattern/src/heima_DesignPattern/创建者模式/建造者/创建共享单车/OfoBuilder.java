package heima_DesignPattern.创建者模式.建造者.创建共享单车;

/**
 * @version v1.0
 * @ClassName: OfoBuilder
 * @Description: TODO 类描述
 * @Author: Orange
 **/
public class OfoBuilder extends Builder {
    public void buildFrame() {
        bike.setFrame("铝合金车架");
    }

    public void buildSeat() {
        bike.setSeat("橡胶车座");
    }

    public Bike createBike() {
        return bike;
    }
}
