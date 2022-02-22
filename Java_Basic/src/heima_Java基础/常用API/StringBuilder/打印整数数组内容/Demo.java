package heima_Java基础.常用API.StringBuilder.打印整数数组内容;

/**
 * @version v1.0
 * @ClassName: Demo
 * @Description: TODO 类描述
 * @Author: Orange
 **/
public class Demo {
    public static void main(String[] args) {
        int[] arr1 = null;
        System.out.println(toString(arr1));

        int[] arr2 = {10, 11, 4};
        System.out.println(toString(arr2));

        int[] arr3 = {};
        System.out.println(toString(arr3));
    }

    //1. 定义方法返回任意整型数组，返回数组内容格式
    public static String toString(int[] arr) {
        if (arr != null) {
            //2. 开始拼接
            StringBuilder sb = new StringBuilder("[");
            for (int i = 0; i < arr.length; i++) {
                sb.append(arr[i]).append(i == arr.length - 1 ? "" : ", ");
            }
            sb.append("]");
            return sb.toString();
        } else {
            return null;
        }
    }
}
