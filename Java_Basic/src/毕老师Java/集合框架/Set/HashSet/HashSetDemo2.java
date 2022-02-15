package 毕老师Java.集合框架.Set.HashSet;

import java.util.HashSet;
import java.util.Iterator;

/**
 * @version v1.0
 * @ClassName: HashSetDemo2
 * @Description: TODO 类描述
 * @Author: Orange
 **/
public class HashSetDemo2 {
    public static void main(String[] args) {
        HashSet hs = new HashSet();
        hs.add("Java1");
        hs.add("Java2");
        hs.add("Java3");
        hs.add("Java4");

        //set集合取出只有一种方式：迭代器
        for(Iterator it = hs.iterator(); it.hasNext();)
            System.out.println(it.next());//并不是按照传顺序打印的，而是按照地址值
    }
}
