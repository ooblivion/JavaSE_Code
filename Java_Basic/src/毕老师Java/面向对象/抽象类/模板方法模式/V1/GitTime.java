package 毕老师Java.面向对象.抽象类.模板方法模式.V1;

/**
 * @version v1.0
 * @ClassName: GitTime
 * @Description: TODO 类描述
 * @Author: Orange
 **/
class GetTime{
    public void getTime(){
        long start = System.currentTimeMillis();

        //下面两行代码是可变部分
        for(int x = 0; x<10000; x++)
            System.out.println(x);

        long end = System.currentTimeMillis();
        System.out.println("毫秒："+(end - start));
    }
}
