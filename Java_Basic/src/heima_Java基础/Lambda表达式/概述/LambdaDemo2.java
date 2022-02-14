package heima_Java基础.Lambda表达式.概述;

/**
 * @version v1.0
 * @ClassName: LambdaDemo2
 * @Description: TODO 类描述
 * @Author: Orange
 **/
public class LambdaDemo2 {
    //Lambda只能简化接口中只有一个抽象方法的匿名内部类形式
    //
    public static void main(String[] args) {
        Swimming s1 = new Swimming() {
            @Override
            public void swim() {
                System.out.println("swimming");
            }
        };
        go(s1);

        System.out.println("===");
        Swimming s2 = () -> {
            System.out.println("simple");
        };
        go(s2);

        System.out.println("===");
        go(new Swimming() {
            @Override
            public void swim() {
                System.out.println("more simple");
            }
        });

        System.out.println("===");
        go(()->{
            System.out.println("more more simple");
        });
    }


    public static void go(Swimming s){
        System.out.println("begin ...");
        s.swim();
        System.out.println("end ...");
    }
}

//一旦加上这个注解就必须是函数式接口，里面只能有一个抽象方法
@FunctionalInterface
interface Swimming{
    void swim();//默认为抽象方法
}

//有点像ES6的箭头函数