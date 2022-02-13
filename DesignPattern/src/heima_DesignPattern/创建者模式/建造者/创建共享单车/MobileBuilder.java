package heima_DesignPattern.创建者模式.建造者.创建共享单车;

/**
 * @version v1.0
 * @ClassName: MobileBuilder
 * @Description: TODO 类描述
 * @Author: Orange
 **/
public class MobileBuilder extends Builder {

    public void buildFrame() {
        bike.setFrame("碳纤维车架");
    }

    public void buildSeat() {
        bike.setSeat("真皮车座");
    }

    public Bike createBike() {
        return bike;
    }
}
