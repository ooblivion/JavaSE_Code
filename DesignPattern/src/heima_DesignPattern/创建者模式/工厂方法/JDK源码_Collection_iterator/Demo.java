package heima_DesignPattern.创建者模式.工厂方法.JDK源码_Collection_iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @version v1.0
 * @ClassName: Demo
 * @Description: 使用迭代器遍历集合，获取集合中的元素，而单列集合获取迭代器的方法就使用到了工厂方法模式
 * @Author: Orange
 **/
public class Demo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("令狐冲");
        list.add("风清扬");
        list.add("任我行");

        //获取迭代器对象
        Iterator<String> it = list.iterator();
        //使用迭代器遍历
        while(it.hasNext()) {
            String ele = it.next();
            System.out.println(ele);
        }
    }
}