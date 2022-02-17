package 毕老师Java.集合框架.Set.TreeSet.TreeSet练习.按照字符串的长度排序;

import java.util.Iterator;
import java.util.TreeSet;

/**
 * @version v1.0
 * @ClassName: ClientV1
 * @Description: 默认按照首字母排序
 * @Author: Orange
 **/
public class ClientV1 {
    public static void main(String[] args) {
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
