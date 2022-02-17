package 毕老师Java.集合框架.Set.TreeSet.TreeSet排序;

import java.util.Comparator;

/**
 * @version v1.0
 * @ClassName: MyCompare
 * @Description: 判断姓名 自定义比较器
 * @Author: Orange
 **/
class MyCompare implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        Person p1 = (Person)o1;
        Person p2 = (Person)o2;
        //return p1.getName().compareTo(p2.getName());
        int num = p1.getName().compareTo(p2.getName());

        //当主要条件相同时判断次要条件
        if(num == 0){
            if(p1.getAge()>p2.getAge())
                return 1;
            if(p1.getAge() == p2.getAge())
                return 0;
            return -1;
        }
        return num;
    }
    //不用覆盖euqlas方法，由于该类以及继承了Object

    //或者用基本数据类	型封装 return new Integer(p1.getAge()).compareTo(new Integer(p2.getAge()))
}
