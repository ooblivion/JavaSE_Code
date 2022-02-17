package heima_Java基础.面向对象.抽象类.模板方法模式.V1;

/**
 * @version v1.0
 * @ClassName: Client
 * @Description: TODO 类描述
 * @Author: Orange
 **/
public class Client {
}

/*
使用场景
   当系统种出现同一个功能在多处开发，而该功能中大部分代码是一样的其中只有部分可能不同
   将不能决定的功能定义成抽象方法让子类去实现

需求
    某软件公司为银行业务支撑系统开发一个利息结算系统，账户有活期和定期两种
    活期是0.35%，定期是1.75%，定期如果满10w给予3%的额外收益
    结算利息要先进行用户名，密码验证，验证失败直接提示，登录成功进行结算
分析
*/
