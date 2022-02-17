package 毕老师Java.集合框架.Set.TreeSet;

import com.sun.source.tree.Tree;

import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * @version v1.0
 * @ClassName: TreeSetDemo1
 * @Description: 自动排序
 * @Author: Orange
 **/
public class TreeSetDemo1 {
    public static void main(String[] args) {
        TreeSet ts = new TreeSet();
        ts.add("bbb");
        ts.add("ccc");
        ts.add("eee");
        ts.add("ddd");
        ts.add("aaa");
        for(
            Iterator it = ts.iterator(); it.hasNext();){
            System.out.println(it.next());
        }

        System.out.println("===");

        HashSet hs = new HashSet();
        hs.add("aaa");
        hs.add("bbb");
        hs.add("ccc");
        hs.add("ddd");
        hs.add("eee");
        for(Iterator it = hs.iterator(); it.hasNext(); ){
            System.out.println(it.next());
        }
    }

}
