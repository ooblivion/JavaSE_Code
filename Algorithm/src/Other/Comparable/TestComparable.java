package Other.Comparable;

public class TestComparable {
    public static void main(String[] args) {
        Student s1 = new Student();
        Student s2 = new Student();
        s1.setUsername("mike");
        s1.setAge(22);
        s2.setUsername("tom");
        s2.setAge(34);
        Comparable max = getMax(s1, s2);//输出年龄较大的
        System.out.println(max);
    }
    public static Comparable getMax(Comparable c1, Comparable c2){
        int result = c1.compareTo(c2);
        if(result>=0)
            return c1;
        else
            return c2;
    }
}
