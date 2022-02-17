package 毕老师Java.集合框架.Set.HashSet.HashSet判断;

/**
 * @version v1.0
 * @ClassName: Person
 * @Description: TODO 类描述
 * @Author: Orange
 **/
class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.age = age;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int hashCode() {
        return name.hashCode() + age * 11;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Person))
            return false;
        Person p = (Person) obj;
        return this.name.equals(p.name) && this.age == p.age;
    }
}
