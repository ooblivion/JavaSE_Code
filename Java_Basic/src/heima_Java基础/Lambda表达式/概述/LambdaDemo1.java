package heima_Java基础.Lambda表达式.概述;

/**
 * @version v1.0
 * @ClassName: LambdaDemo1
 * @Description: TODO 类描述
 * @Author: Orange
 **/
public class LambdaDemo1 {
    public static void main(String[] args) {
        //目标：学会Lambda的标准格式简化匿名内部类
        Animal a = new Animal() {
            @Override
            public void run() {
                System.out.println("乌龟跑的很慢");
            }
        };
        a.run();
    }
}
abstract class Animal{
    public abstract void run();
}
