package 毕老师Java.面向对象.抽象类.模板方法模式.V1;

/**
 * @version v1.0
 * @ClassName: GetTimeDemo
 * @Description: TODO 类描述
 * @Author: Orange
 **/
/*
需求：获取一段程序运行的时间
原理：获取程序开始和结束的时间相减即可
获取时间：currentTimeMillis() 返回当前时间与1970-1-1之间的时间差，以毫秒为单位 end-start
*/
public class GetTimeDemo {
    public static void main(int[] args){
        GetTime g1 = new GetTime();
        g1.getTime();
    }
}
//每次都要该代码，为了更方便，可以将除了代码运行的部分（计算时间部分）封装
