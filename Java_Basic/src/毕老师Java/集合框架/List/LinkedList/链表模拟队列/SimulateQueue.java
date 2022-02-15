package 毕老师Java.集合框架.List.LinkedList.链表模拟队列;

/**
 * @version v1.0
 * @ClassName: SimulateQueue
 * @Description: TODO 类描述
 * @Author: Orange
 **/
public class SimulateQueue {
    public static void main(String[] args){
        QueueDemo qd = new QueueDemo();
        qd.add("aaa");
        qd.add("bbb");
        qd.add("ccc");
        qd.add("ddd");
        qd.show();
        System.out.println(qd.isNull());

        //直接返回会返回一个指针
        qd.add("rsndm");
        qd.show();

        //返回并删除First
        System.out.println(qd.get());
        qd.show();
    }
}
