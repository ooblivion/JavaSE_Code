package heima_Java基础.面向对象.接口.注意事项;

/**
 * @version v1.0
 * @ClassName: Client
 * @Description: TODO 类描述
 * @Author: Orange
 **/
public class Client {
    public static void main(String[] args) {
        //1. 接口不能创建对象
        //2. 一个类实现多个接口，多个接口中有同样的静态方法不冲突，因为子类不能调用父类的静态方法
        //3. 一个类继承了父类，同时又实现了接口，父类中和接口中又有同名方法时，默认用父类的
        //4. 一个类实现了多个接口，多个接口中有同名方法时，不冲突，重写该方法即可
        //5. 多个接口存在规范冲突时，不能多继承

        //3.优先使用父类的方法
        cat c = new cat();
        c.eat();//Animal eat some

    }
}

// 2 === === ===

interface A{
    static void test(){
        System.out.println("test");
    }
}

interface B{
    static void test(){
        System.out.println("B");
    }
}

class C implements A,B{
    public static void main(String[] args) {
        //子类不能调用父类的静态方法，静态只能接口自己调用
        //C.test();

    }
}

// 3 === === ===
interface Food{
    default void eat(){
        System.out.println("Food eat some");
    }
}

class Animal{
    public void eat(){
        System.out.println("Animal eat some");
    }
}

class cat extends Animal implements Food{

}

// 4 === === ===

interface AAA{
    default void go(){
        System.out.println("aaa");
    }
}

interface BBB{
    default void go(){
        System.out.println("bbb");
    }
}

class CCC implements BBB, AAA{
    //有多个同名父类方法时，无法使用父类的方法
    @Override
    public void go() {
        System.out.println("ccc go");
    }
}

// 5 === === ===

interface AAAA{
    void run();
}

interface BBBB{
    int run();
}

//class CCCC implements BBBB, AAAA{
//    run
//}
//继承的俩个接口中的同名方法返回值不同，不符合规范