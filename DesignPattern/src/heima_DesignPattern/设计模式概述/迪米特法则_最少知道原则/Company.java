package heima_DesignPattern.设计模式概述.迪米特法则_最少知道原则;

/**
 * @version v1.0
 * @className: Company
 * @description: 公司类
 * @author: Orange
 **/
public class Company {
    private String name;

    public Company(String name) {
        this.name=name;
    }

    public String getName() {
        return name;
    }
}
