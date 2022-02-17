package heima_Java基础.面向对象.接口.JDK8以后接口新增方法.Test;

/**
 * @version v1.0
 * @ClassName: Client
 * @Description: TODO 类描述
 * @Author: Orange
 **/
/*
允许接口中直接定义带有方法体的方法
在丰富接口功能的同时又不对子类代码进行更改
*/
public class Client {
    public static void main(String[] args) {
        ddd cd = new ddd();
        cd.rund();

        sss cs = new sss();
        //cs.inAddr();
        //concreteStatic.inAddr();
        staticDemo.runs();

        ppp cp = new ppp();
        cp.another();
    }
}


