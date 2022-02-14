package 毕老师Java.面向对象.子父类中的构造函数;

/**
 * @version v1.0
 * @ClassName: FaSonConstructor
 * @Description: TODO 类描述
 * @Author: Orange
 **/
public class FaSonConstructor {
    public static void main(String[] args) {
        Son s1 = new Son();
        Son s2 = new Son(1);
//        Father run
//        Son run
//        Father run
//        1 Son run
    }
}
class Father{
    Father(){
        System.out.println("Father run");
    }
}
class Son extends Father{
    //super();
    Son(){
        System.out.println("Son run");
    }
    //super();
    Son(int i){
        System.out.println(i+" Son run");
    }
}

