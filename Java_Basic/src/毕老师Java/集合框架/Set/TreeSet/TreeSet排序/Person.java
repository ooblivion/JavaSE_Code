package 毕老师Java.集合框架.Set.TreeSet.TreeSet排序;

/**
 * @version v1.0
 * @ClassName: Person
 * @Description: TODO 类描述
 * @Author: Orange
 **/
class Person implements Comparable//强制让学生具备比较性
{
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
        return name.hashCode()+age*11;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Person))
            return false;
        Person p = (Person)obj;
        return this.name.equals(p.name)&&this.age==p.age;
    }

    @Override
    public int compareTo(Object o) {
        if(!(o instanceof Person))
            throw new RuntimeException("对象传入错误");
        Person p = (Person)o;
        if(this.age > p.age)
            return 1;
        else if(this.age == p.age)
            return this.name.compareTo(p.name);
            //return 0;
        else
            return -1;
    }
}