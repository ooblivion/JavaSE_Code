package 毕老师Java.集合框架.List.ArrayList.除去ArrayList中的重复元素;

import java.util.ArrayList;
import java.util.Collection;
import java.util.ListIterator;

/**
 * @version v1.0
 * @ClassName: DeleteDuplicateInArrayListV1
 * @Description:
 *  一个容器中有多个A多个B，要求返回一个只有一个A和B的ArrayList
 *    定义一个功能，将ArrayList传入后返回一个元素为1的ArrayList
 *    将原容器中的元素装入新容器，每次装的时候进行一次判断，没有就装，有就丢掉
 * @Author: Orange
 **/
public class DeleteDuplicateInArrayListV1 {
    public static void main(String[] args){
        ArrayList<String> al = new ArrayList();
        al.add("java3");
        al.add("java2");
        al.add("java3");
        al.add("java4");
        al.add("java3");
        sop(al);
        al = single_filter(al);
        sop(al);
        //但每次都是先出现的会被保存
    }
    public static ArrayList single_filter(ArrayList al){
        //定义一个临时容器
        ArrayList newal = new ArrayList();
        //要遍历一遍传入的容器
        ListIterator lit = al.listIterator();
        ListIterator newal_lit = newal.listIterator();
        while(lit.hasNext()){
            Object obj = lit.next();//用个容器把next装下进行判断
            if(!newal.contains(obj))
                newal.add(obj);
//             if(!newal.contains(lit.next()))
//                 newal_lit.add(lit.next());
        }
        return newal;
    }
    public static void sop(Object obj){
        System.out.println(obj);
    }
}
