package heima_DesignPattern.设计模式概述.迪米特法则_最少知道原则;

/**
 * @version v1.0
 * @className: Star
 * @description: 明星类
 * @author: Orange
 **/
public class Star {
    private String name;

    public Star(String name) {
        this.name=name;
    }

    public String getName() {
        return name;
    }
}
