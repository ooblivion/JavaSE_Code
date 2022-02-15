package 毕老师Java.集合框架.List.Vector;

import java.util.Enumeration;
import java.util.Vector;

/**
 * @version v1.0
 * @ClassName: VectorEnumDemo
 * @Description: TODO 类描述
 * @Author: Orange
 **/
public class VectorEnumDemo {
    public static void main(String[] args) {
        Vector v = new Vector();
        v.add("ve1");
        v.add("ve2");
        v.add("ve3");
        v.add("ve4");
        sop(v);
//        for(Iterator it = v.iterator();it.hasNext();)
//            sop(it.next());
//        Enumeration en = v.elements();
        for(Enumeration en = v.elements(); en.hasMoreElements();)
            sop(en.nextElement());
    }
    public static void sop(Object obj){
        System.out.println(obj);
    }
}
