package heima_Java基础.集合框架.集合常用API;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * @version v1.0
 * @ClassName: CollectionAPI
 * @Description: add addAll contain clear isEmpty remove size toArray
 * @Author: Orange
 **/
public class CollectionAPI {
    public static void main(String[] args) {
        Collection<String> list = new ArrayList();
        list.add("111");
        list.add("aaa");
        list.add("aaa");
        System.out.println(list.add("bbb"));//true
        System.out.println(list.size());//4
        System.out.println(list.contains("111"));//true

        System.out.println(list.remove("222"));//false
        System.out.println(list.remove("111"));//true
        System.out.println(list);

        Object[] arr = list.toArray();
        System.out.println(Arrays.toString(arr) + " == " + list);

        System.out.println("=== extend === combine two Collection");
        Collection c1 = new ArrayList();
        Collection c2 = new ArrayList();
        c1.add("aaa");
        c1.add("bbb");
        c2.add("111");
        c2.add("222");
        c1.addAll(c2);
        System.out.println(c1);
        System.out.println(c2);

    }
}
