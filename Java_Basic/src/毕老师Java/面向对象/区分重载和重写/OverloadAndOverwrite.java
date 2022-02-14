package 毕老师Java.面向对象.区分重载和重写;

/**
 * @version v1.0
 * @ClassName: OverloadAndOverwrite
 * @Description: TODO 类描述
 * @Author: Orange
 **/
public class OverloadAndOverwrite {
    public static void main(String[] args) {
        Son s1 = new Son();
    }
}
class Fa{
    void show(){
        System.out.println("fa show");
    }
    void speak(){
        System.out.println("VB");
    }
}
class Son extends Fa{
    void show(){
        System.out.println("son show");
    }
    void speak(){//子类中的方法和父类同名
        System.out.println("Java");
    }//当子类继承了父类，沿袭了父类的功能到子类中，子类虽有该功能，功能的内容却和父类的不一致，这时没有必要定义新功能，而是使用父类的特性，保留父类的功能定义，并重写功能类容。有利于功能拓展
}
class Tel{
    void show(){
        System.out.println("number");
        //System.out.println();("name");
    }
}
//升级，修改源码令人头大
class UpTel extends Tel{
    void show(){
        super.show();//可以调用父类的原有功能
        //System.out.println();("number");
        System.out.println("name");
    }
}
//再调用对象的时候只需要调用新的类中的方法即可，这就是覆写用于拓展的例子
