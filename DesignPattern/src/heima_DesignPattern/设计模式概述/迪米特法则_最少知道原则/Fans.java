package heima_DesignPattern.设计模式概述.迪米特法则_最少知道原则;

/**
 * @version v1.0
 * @className: Fans
 * @description: 粉丝类
 * @author: Orange
 **/
public class Fans {
    private String name;

    public Fans(String name) {
        this.name=name;
    }

    public String getName() {
        return name;
    }
}
