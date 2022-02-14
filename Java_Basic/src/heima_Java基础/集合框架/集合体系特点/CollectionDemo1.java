package heima_Java基础.集合框架.集合体系特点;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

/**
 * @version v1.0
 * @ClassName: CollectionDemo1
 * @Description: TODO 类描述
 * @Author: Orange
 **/
public class CollectionDemo1 {
    public static void main(String[] args) {
        //有序 可重复 有索引
        Collection list = new ArrayList();//多态
        list.add("java");
        list.add("java");
        list.add("Java");
        list.add("Demo");
        list.add(12);
        list.add(11);
        list.add(false);
        System.out.println(list);

        //无序 不重复 无索引
        Collection list1 = new HashSet();
        list1.add("java");
        list1.add("java");
        list1.add("java");
        list1.add("Java");
        list1.add("Demo");
        list1.add(12);
        list1.add(11);
        list1.add(false);
        System.out.println(list1);

        //用泛型可以在编译之前就排除ClassCastException问题
        Collection<String> list2 = new ArrayList();
        list2.add("aaa");
        list2.add("bbb");
        list2.add("22");
        //list2.add(22);
        System.out.println(list2);

        //集合和泛型不能存储基本数据类型
        Collection<Integer> list3 = new ArrayList<>();
        list3.add(23);
        list3.add(233);
        list3.add(2333);
        System.out.println(list3);
    }
}
