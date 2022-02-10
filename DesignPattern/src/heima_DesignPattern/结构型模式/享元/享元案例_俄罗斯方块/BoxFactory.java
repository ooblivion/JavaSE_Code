package heima_DesignPattern.结构型模式.享元.享元案例_俄罗斯方块;

import javax.swing.*;
import java.util.HashMap;

/**
 * @version v1.0
 * @className: BoxFactory
 * @description: 工厂类，将该类设计为单例
 * @author: Orange
 **/
public class BoxFactory {
    public HashMap<String, AbstractBox> map;

    //在构造方法中提供初始化操作
    private BoxFactory(){
        map = new HashMap<String, AbstractBox>();
        map.put("I", new IBox());
        map.put("Z", new ZBox());
        map.put("O", new OBox());
    }

    //获取单例对象，提供一个方法获取该类的工厂对象（构造方法已经私有了
    //单例模式の饿汉式
    public static BoxFactory getInstance(){
        //由于该方法是静态的，要声明成员变量
        return factory;
    }

    private static BoxFactory factory = new BoxFactory();

    //根据名称获取图形对象（多态？
    public AbstractBox getShape(String name){
        return map.get(name);
    }

}
