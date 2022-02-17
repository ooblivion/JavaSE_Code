package 毕老师Java.集合框架.Set.HashSet;

import java.util.HashSet;
import java.util.Iterator;

/**
 * @version v1.0
 * @ClassName: HashSetDemo3
 * @Description: 存自定义元素
 * @Author: Orange
 **/
public class HashSetDemo3 {
    public static void main(String[] args) {
        HashSet hs = new HashSet();
        hs.add(new Person("a", 1));
        hs.add(new Person("b", 2));
        hs.add(new Person("c", 3));
        hs.add(new Person("c", 3));
        hs.add(new Person("d", 4));
        //hs.contains(new Person("a",1));
        sop(hs.contains(new Person("a",1)));//true 先判断hash值
        sop(hs);
        hs.remove(new Person("c", 3));
        for (Iterator it = hs.iterator(); it.hasNext();){
            Person p = (Person) it.next();
            sop(p.getAge()+"..."+p.getName());
        }
    }

    public static void sop(Object obj){
        System.out.println(obj);
    }
}

class Person{
    private String Name;
    private int age;

    public int getAge() {
        return age;
    }

    public String getName() {
        return Name;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public void setName(String name) {
        this.Name = name;
    }
    Person(String Name, int age){
        setAge(age);
        setName(Name);
    }

    //重写父类中的equals方法
    @Override
    public boolean equals(Object obj){
        if(!(obj instanceof Person))
            return false;
        //注意这个不能用泛型
        Person p = (Person)obj;
        //如果该行答应代表equals被调用
        System.out.println(this.Name + " equals " + p.Name);
        return this.Name.equals(p.Name) && this.age == p.age;
    }

    @Override
    public int hashCode() {
        //return 20;//super.hashCode();
        return Name.hashCode()+age;
    }
}
