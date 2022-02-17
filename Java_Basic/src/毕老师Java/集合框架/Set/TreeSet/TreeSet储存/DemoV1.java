package 毕老师Java.集合框架.Set.TreeSet.TreeSet储存;

import java.util.Iterator;
import java.util.TreeSet;

/**
 * @version v1.0
 * @ClassName: TreeSetDemo2
 * @Description:
 *  储存元素为对象，并按照对象中的某一成员排序
 * @Author: Orange
 **/
public class DemoV1 {
    public static void main(String[] args) {
        TreeSet ts = new TreeSet();
        ts.add(new PersonV1("aaa",1));
        ts.add(new PersonV1("ccc",3));
        ts.add(new PersonV1("bbb",2));
        ts.add(new PersonV1("ddd",4));
        ts.add(new PersonV1("xxx",2));
        //sop(ts);
        //类型转换异常 Perosn不能转换成Comparable
        for(Iterator it = ts.iterator(); it.hasNext();){
            PersonV1 p = (PersonV1)it.next();
            sop(p.getName()+" = "+p.getAge());//有序打印
        }
    }

    public static void sop(Object obj){
        System.out.println(obj);
    }
}

//问题：当同age不同名的两个参数传入时只会保留第一个传入的

