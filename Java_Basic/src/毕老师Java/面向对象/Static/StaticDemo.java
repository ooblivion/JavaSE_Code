package 毕老师Java.面向对象.Static;

/**
 * @version v1.0
 * @ClassName: StaticDemo
 * @Description: TODO 类描述
 * @Author: Orange
 **/
public class StaticDemo {
    public static void main(String[] args) {
        peo1 p1 = new peo1();
        p1.name = "ybb";
        p1.show();
        peo1 p2 = new peo1();
        p2.name = "byy";
        p2.setCountry("vn");
        p2.show();
        System.out.println("peo1 is " + peo1.sex);
    }
}
class peo1{
    String name;//成员变量 or 实例变量 or 对象变量 需要对象才能存在
    String country = "japan";
    //多个对象存在共同数据的时候可以将该数据设为static，可以减少内存的占用
    static int sex = 1;//纯纯的猛1 静态成员变量 or 类变量 不需要对象也存在
    public void show(){
        System.out.println(name + " from " + country + " and is "+ sex);
    }
    void setCountry(String country1){
        country = country1;
    }
}