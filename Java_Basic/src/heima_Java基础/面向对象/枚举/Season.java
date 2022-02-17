package heima_Java基础.面向对象.枚举;

public enum Season {
    //枚举的第一行必须罗列枚举的对象名称，建议全部大写
    SPRING, SUMMER, AUTUMN, WINTER;
}
/*
public enum Season {
    SPRING,
    SUMMER,
    AUTUMN,
    WINTER;

    private Season() {
    }

- 枚举都是继承了枚举类型，java.lang.Enum
- 枚举都是最终类，不可以被继承
- 构造器都是私有的，对外不能构建对象
- 枚举的第一行都是默认罗列枚举对象的名称
- 枚举类相当于是多例模式
*/