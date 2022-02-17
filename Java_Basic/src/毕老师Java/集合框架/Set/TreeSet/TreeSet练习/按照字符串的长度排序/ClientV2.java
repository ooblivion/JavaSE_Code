package 毕老师Java.集合框架.Set.TreeSet.TreeSet练习.按照字符串的长度排序;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * @version v1.0
 * @ClassName: ClientV2
 * @Description: 也可以使用匿名内部类，但阅读性会差一点
 * @Author: Orange
 **/
public class ClientV2 {
    public static void main(String[] args) {
        TreeSet treeSet1 = new TreeSet(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                String s1 = (String)o1;
                String s2 = (String)o2;
                int num = new Integer(s1.length()).compareTo(new Integer(s2.length()));
                if(num == 0)
                    return s1.compareTo(s2);
                return num;
            }
        });

        TreeSet ts = new TreeSet(new Mycompare());
        ts.add("aaaaa");
        ts.add("aa");
        ts.add("aaa");
        ts.add("ccc");
        ts.add("a");
        for(Iterator it = ts.iterator(); it.hasNext();)
            sop(it.next());
    }
    public static void sop(Object obj){
        System.out.println(obj);
    }
}

//如果用lambda表达式该如何
//Lambda只能简化接口中只有一个抽象方法的匿名内部类形式