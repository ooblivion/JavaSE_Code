package 毕老师Java.集合框架.List.ArrayList.自定义对象存入ArrayList并去除重复元素;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

/**
 * @version v1.0
 * @ClassName: DeleteDuplicateInArrayListV2
 * @Description:
 *  存入人对象，同姓名年龄，视为同一个人，为重复元素需要删除
 * @Author: Orange
 **/
public class DeleteDuplicateInArrayListV2 {
    public static void main(String[] args) {
        ArrayList al = new ArrayList();
        Person p1 = new Person("aaa", 11);
        Person p2 = new Person("bbb", 22);
        Person p3 = new Person("ccc", 33);
        Person p4 = new Person("aaa", 11);

        //a1.add(Objet obj); Object obj = new Person(...);数据类型提升
        al.add(p1);
        al.add(p2);
        al.add(p3);
        al.add(p4);
        sop(al);
        for(Iterator it = al.iterator(); it.hasNext();){
            //sop(it.next().getName() + " : " + it.next().getAge();
            //Object obj = it.next();
            //Person p = (Person)obj;
            Person p = (Person)it.next();
            sop(p.getName()+"::"+p.getAge());
        }

        al = singleElement(al);
        sop(al);
        for(Iterator it = al.iterator(); it.hasNext();){
            //sop(it.next().getName() + " : " + it.next().getAge();
            //Object obj = it.next();
            //Person p = (Person)obj;
            Person p = (Person)it.next();
            sop(p.getName()+"::"+p.getAge());
        }
    }

    public static ArrayList singleElement(ArrayList al){
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

    public static void sop(Object obj) {
        System.out.println(obj);
    }
}
