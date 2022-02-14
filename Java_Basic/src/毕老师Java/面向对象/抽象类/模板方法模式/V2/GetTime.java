package 毕老师Java.面向对象.抽象类.模板方法模式.V2;

/**
 * @version v1.0
 * @ClassName: GetTime
 * @Description: TODO 类描述
 * @Author: Orange
 **/
abstract class GetTime{
    public final void getTime(){ //final 强制无法复写
        long start = System.currentTimeMillis();
        runcode();
        long end = System.currentTimeMillis();
        System.out.println("毫秒："+(end - start));
    }

//    public void runcode()//把需要复写的提取出来方便子类复写
//    {
//        for(int x = 0; x<10000; x++)
//            System.out.println(x);
//    }

    //===

    public abstract void runcode();//抽象方法不能有主体
}