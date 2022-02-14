package 毕老师Java.集合框架.Collection;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @version v1.0
 * @ClassName: GetTwoIntersection
 * @Description: TODO 类描述
 * @Author: Orange
 **/
public class GetTwoIntersection {
    public static void main(String[] args) {
        Collection<String> c1 = new ArrayList<>();
        Collection<String> c2 = new ArrayList<>();
        c1.add("Java1");
        c1.add("Java2");
        c1.add("Java3");
        c1.add("Java4");
        c1.add("Java5");

        c2.add("Java5");
        c2.add("Test");

        c1.retainAll(c1);//c1中只会保留和c2交集的元素，没有的情况下就为空

        sop(c1.retainAll(c2));//打印结果为true
        sop(c1);//打印结果为交集的字符串
    }
    public static void sop(Object obj){
        System.out.println(obj);
    }
}
