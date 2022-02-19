package heima_Java基础.面向对象.多态.类型转换;

/**
 * @version v1.0
 * @ClassName: Demo
 * @Description: TODO 类描述
 * @Author: Orange
 **/
//为了调用子类的独有功能
//强制类型转换能解决什么问题？需要注意什么？
//  可以转换成真正的子类型，从而调用子类独有的功能
//  有继承或实现的两个类型就可以使用强制类型转换，编译无问题
public class Demo {
    public static void main(String[] args) {
        Animal a1 = new Dog();
        Animal a2 = new Tortoise();

        a1.run();
        a2.run();
        //a1.brack();

        //强制类型转换，父类转子类
        Dog d = (Dog)a1;
        d.brack();

        //编译阶段不报错，有继承或实现关系，编译阶段可以强制
        //ClassCastException
        Dog dd = (Dog) a2;

        //转换类型后如果和真实类型不一样，会抛出异常ClassCastException
        //建议在使用之前先用instanceof判断当前对象的真是性，再进行强制类型转换

        if(a1 instanceof Dog){
            Dog ddd = (Dog) a1;
            ddd.brack();
        }else if (a1 instanceof Tortoise){
            Tortoise t = new Tortoise();
            //t.special_mothod()
        }
    }

}
