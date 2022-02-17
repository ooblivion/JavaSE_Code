package heima_Java基础.面向对象.抽象类.模板方法模式.V1;

/**
 * @version v1.0
 * @ClassName: CurrentAccount
 * @Description: TODO 类描述
 * @Author: Orange
 **/
public class CurrentAccount {
    private String cardId;
    private double money;

    public CurrentAccount(){
    }

    public CurrentAccount(String cardId, double money){
        this.cardId = cardId;
        this.money = money;
    }

    //登录结算利息
    public void handle(String loginName, String passWord){
        //判断登录是否成功
        if("orange".equals(loginName) && "123456".equals(passWord)){
            System.out.println("login successful");
            //结算利息，唯一需要抽象的地方
            double result = money*0.0175;
            //输出利息详细
            System.out.println("本账户利息："  +result);
        }else {
            System.out.println("账号或密码错误");
        }
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
}
