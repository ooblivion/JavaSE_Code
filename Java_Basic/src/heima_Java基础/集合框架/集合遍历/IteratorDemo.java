package heima_Java基础.集合框架.集合遍历;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @version v1.0
 * @ClassName: IteratorDemo
 * @Description: TODO 类描述
 * @Author: Orange
 **/
public class IteratorDemo {
    public static void main(String[] args) {
        Collection<String> list = new ArrayList();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        System.out.println(list);

        //先得到当前集合的迭代器对象
        Iterator<String> iterator = list.iterator();
        String s = iterator.next();
        System.out.println(s);
    }
}
