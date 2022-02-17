package heima_Java基础.面向对象.抽象类.模板方法模式.V2;

/**
 * @version v1.0
 * @ClassName: CurrentAccount
 * @Description: TODO 类描述
 * @Author: Orange
 **/
public class CurrentAccount extends Account{

    public CurrentAccount(String carId, int i){
        super(carId, i);
    }
    @Override
    public double calc() {
        //正式结算利息
        double result = getMoney() * 0.0035;
        return result;
    }
}
