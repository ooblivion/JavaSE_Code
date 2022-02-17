package 毕老师Java.集合框架.Set.TreeSet.TreeSet储存;

/**
 * @version v1.0
 * @ClassName: PersonV2
 * @Description: TODO 类描述
 * @Author: Orange
 **/
class PersonV2 implements Comparable//强制让学生具备比较性
{
    private String name;
    private int age;
    public PersonV2(String name, int age) {
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
        if(!(obj instanceof PersonV2))
            return false;
        PersonV2 p = (PersonV2)obj;
        return this.name.equals(p.name)&&this.age==p.age;
    }

    @Override
    public int compareTo(Object o) {
        if(!(o instanceof PersonV2))
            throw new RuntimeException("对象传入错误");
        PersonV2 p = (PersonV2)o;
        if(this.age > p.age)
            return 1;
        else if(this.age == p.age)
            return this.name.compareTo(p.name);
            //return 0;
        else
            return -1;
    }
}
