package 毕老师Java.集合框架.Set.HashSet;

/**
 * @version v1.0
 * @ClassName: HashSetDemo1
 * @Description: TODO 类描述
 * @Author: Orange
 **/
public class HashSetDemo1 {
    public static void main(String[] args) {
        demo d1 = new demo();
        demo d2 = new demo();
        System.out.println(d1.hashCode());//2054798982
        System.out.println(d2.hashCode());//885951223
    }
}

class demo{
    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
