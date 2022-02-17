package heima_Java基础.面向对象.抽象类.模板方法模式.V2;

/**
 * @version v1.0
 * @ClassName: FixedAccount
 * @Description: TODO 类描述
 * @Author: Orange
 **/
public class FixedAccount extends Account{
    @Override
    public double calc() {
        if (getMoney() >= 0 && getMoney()<=100000){
            double result = getMoney() * 0.0175;
            return result;
        }else {
            double result = getMoney() * 0.0475;
            return result;
        }
    }
}
