package 毕老师Java.面向对象.构造函数;

/**
 * @version v1.0
 * @ClassName: ConstructDemo
 * @Description: TODO 类描述
 * @Author: Orange
 **/
public class ConstructDemo {
    public static void main(String[] args) {
        //new一个就会默认构造一个函数，当一个类中没有定义构造函数的时候没系统会默认给该类加一个空的构造函数，方便该类初始化
        //当定义了构造函数后就不会默认生成构造函数
        person1 p1 = new person1();
        System.out.println("===");
        person1 p2 = new person1("nanami");
        System.out.println("===");
        person1 p3 = new person1("nanami", 24);
        System.out.println(p3.getName());

        p3.setName("wdndm");
        System.out.println(p3.getName());

    }
}
class person1 {
    private String name;
    private int age;
    {
        //构造代码块中的默认先执行
        ybb();
        cry();
    }

    person1() {
        System.out.println("this is a person");
        //cry();
    }

    person1(String str) {
        name = str;
        System.out.println("the person's name is " + name);
        //cry();
    }

    person1(String str, int a) {
        name = str;
        age = a;
        System.out.println("this perosn is "+ name +" and her is "+age+" years old");
        //ybb();
        //cry();
    }

    public void cry() {
        System.out.println("cry cry cry");
    }

    public void ybb(){
        System.out.println("ybb ybb ybb");
    }

    public void setName(String n){
        name = n;
    }

    public String getName(){
        return name;
    }
}