package 毕老师Java.面向对象.This;

/**
 * @version v1.0
 * @ClassName: ThisDemo
 * @Description: TODO 类描述
 * @Author: Orange
 **/
public class ThisDemo {
    public static void main(String[] args) {
        human h1 = new human(22);
        human h2 = new human(22);
        h1.ybb();
        boolean bl = h1.compare_age(h2);
        if(bl == true)
            System.out.println("age is same");
        else
            System.out.println("age is not same");
    }
}

//需求：给人定义一个用于比较年龄是否相同的功能
class human{
    private int age;
    private String name;
    human(){
        System.out.println("this is empty");
    }
    human(int age){
        this.age = age;
    }
    //由于是和别人比较，自己的年龄是已知值，只需要传一个值进来即可，而且要和人比，不能单独是一个数值
    public boolean compare_age(human h){
        //如何判断目前的函数值和传入的是否相等？
//        if(this.age == h.age)
//            return true;
//        else
//            return false;
        return this.age == h.age;//这样写更简洁
    }
    public void ybb(){
        System.out.println("ybb ybb ybb ybb");
    }
}

/*
this的应用：当定义类中功能的时候，该函数内部要用到调用该函数的对象的时候，用this来表示这个对象
但凡本类功能/方法内部用到了本类的对象，都用this来表示
 */