package 毕老师Java.集合框架.Set.HashSet.HashSet判断;

import java.util.HashSet;
import java.util.Iterator;

/**
 * @version v1.0
 * @ClassName: HashSetDemo4
 * @Description: HashSet判断
 * @Author: Orange
 **/
public class HashSetDemo4 {
    public static void main(String[] args) {
        HashSet hs = new HashSet();
        hs.add(new Person("a", 1));
        hs.add(new Person("b", 2));
        hs.add(new Person("c", 3));
        hs.add(new Person("c", 3));
        hs.add(new Person("d", 4));
        //hs.contains(new Person("a",1));
        sop(hs.contains(new Person("a",1)));//true 先判断hash值
        sop(hs);
        hs.remove(new Person("c", 3));
        for (Iterator it = hs.iterator(); it.hasNext();){
            Person p = (Person) it.next();
            sop(p.getAge()+"..."+p.getName());
        }
    }

    public static void sop(Object obj){
        System.out.println(obj);
    }
}

