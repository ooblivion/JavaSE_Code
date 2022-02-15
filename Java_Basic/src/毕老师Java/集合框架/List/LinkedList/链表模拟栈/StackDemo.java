package 毕老师Java.集合框架.List.LinkedList.链表模拟栈;

import java.util.LinkedList;

/**
 * @version v1.0
 * @ClassName: StackDemo
 * @Description: TODO 类描述
 * @Author: Orange
 **/
class StackDemo {
    private LinkedList link;
    StackDemo(){
        link = new LinkedList();
    }

    public void add(Object obj){
        link.addFirst(obj);
    }

    public void push(){

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
/*
将队列中的removeLast改为removeFirst即可

isEmpty() 如果堆栈是空的，则返回true，当堆栈包含元素时，返回false
Object peek() 返回位于栈顶的元素，但是并不在堆栈中删除它
Object pop() 返回位于栈顶的元素，并在进程中删除它
Object push (Object element) 将element压入堆栈，同时也返回element

push
pull
top

*/
