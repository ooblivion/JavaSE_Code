package heima_DesignPattern.创建者模式.单例.懒汉式.静态内部类.反序列化攻击;

import java.io.Serializable;

/**
 * @version v1.0
 * @ClassName: Singleton
 * @Description: 反序列化攻击
 * @Author: Orange
 **/
public class Singleton implements Serializable {

    private static class SingletonHolder {
        private static Singleton instance = new Singleton();
    }

    private Singleton() {

    }

    public static Singleton getInstance() {
        return SingletonHolder.instance;
    }

    public static void main(String[] args) {
//        Singleton instance = Singleton.getInstance();
//        byte[] serialize = SerializationUtils.serialize(instance);
//        Singleton newInstance = SerializationUtils.deserialize(serialize);
//        System.out.println(instance == newInstance);
    }

}

//引入依赖，这个依赖提供了序列化和反序列化工具类
//<dependency>
//    <groupId>org.apache.commons</groupId>
//    <artifactId>commons-lang3</artifactId>
//    <version>3.8.1</version>
//</dependency>