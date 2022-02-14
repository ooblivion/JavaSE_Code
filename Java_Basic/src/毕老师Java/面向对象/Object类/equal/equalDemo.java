package 毕老师Java.面向对象.Object类.equal;

/**
 * @version v1.0
 * @ClassName: equalDemo
 * @Description: TODO 类描述
 * @Author: Orange
 **/
public class equalDemo {
    public static void main(String[] args) {
        Demo d1 = new Demo();
        Demo d2 = new Demo();
        Demo d3 = d1;
        //equal 比较的是地址，也就是指针
        System.out.println(d1.equals(d1));//true
        System.out.println(d1.equals(d2));//false
        System.out.println(d1.equals(d3));//true
        System.out.println(d1 == d3);
        System.out.println("===");
        Data dd1 = new Data();
        Data dd2 = new Data();
        System.out.println(dd1.equals(d1));
        System.out.println("===");
        Self s1 = new Self(3);
        Self s2 = new Self(3);
        Self s3 = new Self(6);
        System.out.println(s1.compare(s2) + " and " + s1.compare(s3));
        System.out.println("===");
        System.out.println(s1.equals(s3));
        //不同类之间也可以比较，编译可以通过但是无法运行，运行报错 ClassCastException
        System.out.println(s1.equals(d1));
        //为了避免不同类之间的比较，可以在首部加上一个判断 instanceof
    }
}

/*
JDK version 1.6.0
clone() //创建并返回此对象的一个副本
equals(Object obj) //可以传入任意类型，是一种多态的应用；比较地址是否相等
finalize() //当垃圾收集器确定不存在该对象的更多引用的时候，由对象的垃圾收集器调用此方法
getClass() //返回此Object运行时的类
hashCode() //返回该对象的哈希值
notify() //唤醒在此对象监视器上等待的单个线程
notifyALL() //唤醒在此监视器上等待的所有线程
toString() //返回对象的字符串表示
wait() //在其他线程调用此对象的notify()方法，或notifyAll()方法前，导致当前进程的等待
wait(long timeout)
wait(long timeout, int nanos)
*/