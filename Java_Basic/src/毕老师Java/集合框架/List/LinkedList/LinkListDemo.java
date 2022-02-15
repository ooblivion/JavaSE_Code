package 毕老师Java.集合框架.List.LinkedList;

import java.util.LinkedList;

/**
 * @version v1.0
 * @ClassName: LinkListDemo
 * @Description: TODO 类描述
 * @Author: Orange
 **/
public class LinkListDemo {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.add("java1");
        ll.add("java2");
        ll.add("java3");
        ll.add("java4");
        sop(ll);//[java1, java2, java3, java4]

        ll.addFirst("add");//复习C数据结构-链表-头插
        sop(ll);//[add, java1, java2, java3, java4]

        //LinkList特有方法
        ll.addFirst("111");
        ll.addLast("999");
        sop(ll.getFirst());//111
        sop(ll.getLast());//999
        sop(ll);//[111, add, java1, java2, java3, java4, 999]
        sop(ll.removeFirst());//111
        sop(ll);//[add, java1, java2, java3, java4, 999]
        sop(ll.removeLast());//999
        sop(ll);//[add, java1, java2, java3, java4]
        sop(ll.getFirst());
        sop(ll.getFirst());
        sop(ll.size());
        sop(ll.removeFirst());
        sop(ll.removeFirst());
        sop(ll);

        //如果链表中没有所需要的元素或是一个空链表，会抛出异常NoSuchElementException
        ll.clear();
        sop(ll.getFirst());
    }
    public static void sop(Object obj){
        System.out.println(obj);
    }
}
/*
get和remove的区别：get获取元素但不删除元素，remove获取元素并删除元素

public E getLast() {
    final LinkedList.Node<E> l = last;
    if (l == null)
        throw new NoSuchElementException();
    return l.item;
}

public E removeFirst() {
    final LinkedList.Node<E> f = first;
    if (f == null)
        throw new NoSuchElementException();
    return unlinkFirst(f);
}

JDK1.6版本后添加了pollFirst，获取并移除列表的第一个元素
如果此列表为空，则返回null（不会抛出异常，
同样的还有peekFirst。但是只会获取不会移除，
分别是removeFirst和getFirst的替代。addFirst的替代是offerList
*/
