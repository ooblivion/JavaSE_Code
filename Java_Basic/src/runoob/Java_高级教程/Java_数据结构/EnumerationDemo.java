package runoob.Java_高级教程.Java_数据结构;

import java.util.Enumeration;
import java.util.Vector;

public class EnumerationDemo {
    public static void main(String args[]) {
        Enumeration<String> days;
        Vector<String> dayNames = new Vector<String>();
        dayNames.add("Sunday");
        dayNames.add("Monday");
        dayNames.add("Tuesday");
        dayNames.add("Wednesday");
        dayNames.add("Thursday");
        dayNames.add("Friday");
        dayNames.add("Saturday");
        days = dayNames.elements();
        while (days.hasMoreElements()){
            System.out.println(days.nextElement());
        }
    }
}
//枚举（The Enumeration）接口定义了一种从数据结构中取回连续元素的方式。
//枚举定义了一个叫nextElement 的方法，该方法用来得到一个包含多元素的数据结构的下一个元素。
