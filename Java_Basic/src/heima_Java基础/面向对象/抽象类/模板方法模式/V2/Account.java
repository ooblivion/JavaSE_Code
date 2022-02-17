package heima_Java基础.面向对象.抽象类.模板方法模式.V2;

/**
 * @version v1.0
 * @ClassName: Account
 * @Description: TODO 类描述
 * @Author: Orange
 **/
public abstract class Account {
    private String cardId;
    private double money;

    public Account(){
    }

    public Account(String cardId, double money){
        this.cardId = cardId;
        this.money = money;
    }

    //为什么模板方法要用handle修饰？
    //模板方法是让子类使用的，不建议重写，一旦子类重写了模板方法就失效了

    //模板方法提高了代码的复用性，
    //模板方法定义了通用结构，模板不能确定的定义成抽象方法
    //使用者只需要关心自己需要实现的功能

    //登录结算利息，模板方法建议用handle修饰
    public final void handle(String loginName, String passWord){
        //判断登录是否成功
        if("orange".equals(loginName) && "123456".equals(passWord)){
            System.out.println("login successful");
            //结算利息，唯一需要抽象的地方
            //当前模板方法知道所有子类账户都要结算利息，但是具体怎么结算，模板不清楚，交给具体的子类来实现
            double result = calc();
            //输出利息详细
            System.out.println("本账户利息："  +result);
        }else {
            System.out.println("账号或密码错误");
        }
    }

    public abstract double calc();

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
