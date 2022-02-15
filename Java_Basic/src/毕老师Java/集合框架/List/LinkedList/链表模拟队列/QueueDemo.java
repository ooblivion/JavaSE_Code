package 毕老师Java.集合框架.List.LinkedList.链表模拟队列;

import java.util.LinkedList;

/**
 * @version v1.0
 * @ClassName: QueueDemo
 * @Description: TODO 类描述
 * @Author: Orange
 **/
class QueueDemo {
    private LinkedList link;
    QueueDemo(){
        link = new LinkedList();
    }
    public void add (Object obj){
        link.addFirst(obj);
    }
    public Object get(){
        return link.removeLast();
    }
    public boolean isNull(){
        return link.isEmpty();//封装
    }
    public void show(){
        sop(link);
    }
    public void sop(Object obj){
        System.out.println(obj);
    }
}
