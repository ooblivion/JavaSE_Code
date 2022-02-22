package heima_Java基础.正则表达式;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

/**
 * @version v1.0
 * @ClassName: TEST
 * @Description: TODO 类描述
 * @Author: Orange
 **/
public class TEST {
    public static void main(String[] args) {
        method_listiterator();
    }
    public static void method_listiterator(){
        //演示列表迭代器 比较特殊
        ArrayList al = new ArrayList();
        al.add("demo1");
        al.add("demo2");
        al.add("demo3");
        al.add("demo4");
        sop(al);
        //对集合中的元素取出，在取出的过程中想做一些操作，比如添加、删除
        for(Iterator it = al.iterator(); it.hasNext();){
            sop(it.next());
        }

        sop("===");
        //Iterator it = al.iterator();
        ListIterator lit = al.listIterator();
        while(lit.hasNext()){
            Object obj = lit.next();
            if(obj.equals("demo2")) {//相当于一个断点，在该位置进行相关操作
                //lit.remove();
                lit.set("demo20");
                lit.add("demo999");
            }
            //sop(it.next());
            //sop(obj);
        }
        sop(al);
    }

    public static void sop(Object o){
        System.out.println(o);
    }
}
