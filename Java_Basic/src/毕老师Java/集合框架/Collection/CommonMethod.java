package 毕老师Java.集合框架.Collection;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @version v1.0
 * @ClassName: CommonMethod
 * @Description: TODO 类描述
 * @Author: Orange
 **/
public class CommonMethod {
    public static void main(String[] args) {
        //创建一个集合容器，使用Collection接口的子类，ArrayList，al这个对象里面能装对象
        ArrayList al = new ArrayList();
        //step1 添加元素
        al.add("java1");//add(Object obj) 多态 Object obj = new String("java1")
        al.add("java2");//复习多态：继承、重写、父类引用子类对象
        al.add("java3");

        //step2 获取集合长度
        sop(al.size());//3

        //打印集合
        sop(al);//[java1, java2, java3]

        //step3 删除元素
        //al.remove("java");//如果传入不存在的，原集合不会有任何改动
        //al.clear();//全部清除
        //sop(al);

        //step4 判断元素
        sop(al.contains("java1"));
        sop(al.isEmpty());

        Person p1 = new Person();
        al.add(p1);//在内存中的位置，集合中存放发不是对象的实体，和数组一样，存放的地址
        for (int i = 0; i < al.size(); i++) {
            al.get(i);
        }
    }
    public static void sop(Object obj){
        System.out.println(obj);
    }
}

//boolean add(E e);
//boolean addAll(Colletion<? extends E> c) 添加一组元素，A容器想添加B容器中的所有内容
//remove(Object o)
//removeAll(Collection<?> c) 移除此集合中也包含在指定集合中的所有元素
//clear() 清空此集合中的元素
//contains(Object o) 是否包含
//returnAll(Collection<?> c) 取两个集合的交集
