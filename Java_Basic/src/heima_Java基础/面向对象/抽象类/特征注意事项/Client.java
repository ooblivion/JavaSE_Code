package heima_Java基础.面向对象.抽象类.特征注意事项;

/**
 * @version v1.0
 * @ClassName: Client
 * @Description: TODO 类描述
 * @Author: Orange
 **/
public class Client {
    public static void main(String[] args) {
        //Animal a = new Animal();
    }
}
/*
特征
    有得有失，得到了抽象方法，失去了创建对象的能力

    抽象类为什么不能创建对象？
        类有的成员抽象类都具备
        抽象类种不一定有抽象方法，有抽象方法的一定是抽象类
        一个继承了抽象类的必须重写完抽象类的全部方法
        不能用abstract修饰变量，代码块，构造器

    对象去调用方法去明确的事情，而抽象类并没有明确的方法，所以不能被创建。

    抽象本身意味着不可实例化

    “抽象类不能直接实例化,并且对抽象类使用 new 运算符会导致编译时错误。
    虽然一些变量和值在编译时的类型可以是抽象的,但是这样的变量和值必须或者为 null,
    或者含有对非抽象类的实例的引用(此非抽象类是从抽象类派生的)。
    允许(但不要求)抽象类包含抽象成员。 抽象类不能被密封。”

    抽象类是有构造器的，而且抽象类一定有构造器，因为抽象类会被子类继承，子类调用构造器的时候一定会调用父类的构造器
*/