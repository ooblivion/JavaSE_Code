package 毕老师Java.集合框架.List.ArrayList.自定义对象存入ArrayList并去除重复元素;

/**
 * @version v1.0
 * @ClassName: Person
 * @Description: TODO 类描述
 * @Author: Orange
 **/
class Person {
    private String name;
    private int age;

    Person() {//空构造函数
    }

    Person(String str, int age) {
        setAge(age);
        setName(str);
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Person))//如果不是所需类直接false或抛异常
            return false;
        Person p = (Person) obj;
        return this.name.equals(p.name) && this.age == p.age;
    }
}
