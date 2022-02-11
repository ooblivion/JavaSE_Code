package heima_DesignPattern.设计模式概述.迪米特法则_最少知道原则;

/**
 * @version v1.0
 * @className: Client
 * @description: 测试类
 * @author: Orange
 **/
public class Client {
    public static void main(String[] args) {
        //创建对象
        Agent agent = new Agent();
        Company company_disny = new Company("disny");
        Fans winny_fans = new Fans("winny fans");
        Star winny = new Star("winny");

        //设置经纪人的明星和业务公司
        agent.setCompany(company_disny);
        agent.setStar(winny);
        agent.setFans(winny_fans);

        //明星洽谈业务
        agent.business();
        //粉丝见面会
        agent.meeting();
    }
}
