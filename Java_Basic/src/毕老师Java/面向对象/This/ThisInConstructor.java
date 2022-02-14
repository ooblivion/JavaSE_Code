package 毕老师Java.面向对象.This;

/**
 * @version v1.0
 * @ClassName: ThisInConstructor
 * @Description:
 * this在构造函数中的作用
 * this语句用于构造函数之间的相互调用，只能传相对应的参数，this语句只能放在构造函数的第一行
 * @Author: Orange
 **/
public class ThisInConstructor {
    public static void main(String[] args) {
        sample1 s1 = new sample1("aaa", 10);
        //sample1 s2 = new sample1("bbb");
        sample1 s3 = new sample1();
    }
}
class sample1{
    private int i_1;
    private String srt_1;
    private String str;
    sample1(String str, int i){
        //this(str);
        this.srt_1 = str;
        this.i_1 = i;
        System.out.println(srt_1 + i_1);
    }
    sample1(String str){
        this.str = str;
        System.out.println(str);
    }
    sample1(){
        System.out.println("this is empty");
    }
}
