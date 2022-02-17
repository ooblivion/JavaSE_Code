package 毕老师Java.集合框架.Set.TreeSet.TreeSet练习.按照字符串的长度排序;

import java.util.Comparator;

/**
 * @version v1.0
 * @ClassName: Mycompare
 * @Description: 自定义比较器
 * @Author: Orange
 **/
class Mycompare implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        String s1 = (String)o1;
        String s2 = (String)o2;
        //还是要注意为0的情况，主要条件判断玩要判断次要条件
        int num = new Integer(s1.length()).compareTo(new Integer(s2.length()));
        if(num == 0)
            return s1.compareTo(s2);
        return num;
    }
}
