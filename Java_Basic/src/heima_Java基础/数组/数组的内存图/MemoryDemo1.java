package heima_Java基础.数组.数组的内存图;

/**
 * @version v1.0
 * @ClassName: MemoryDemo1
 * @Description: TODO 类描述
 * @Author: Orange
 **/
public class MemoryDemo1 {
    public static void main(String[] args) {
        //基本数据类型存的是数据
        int a = 12;
        System.out.println(a);//12
        //数组是引用数据类型
        int[] arr = {11, 22, 44, 12};
        System.out.println(arr);//[I@511baa65
    }
}
