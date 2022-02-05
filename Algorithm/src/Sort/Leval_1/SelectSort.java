package Sort.Leval_1;

import java.util.Arrays;

public class SelectSort {
    public static void main(String[] args) {
        Integer[] arr = {4, 6, 8, 7, 9, 2, 10, 1};
        SelectSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    //TimeComplexity O(n^2)
    public static void SelectSort(Comparable[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            //定义一个变量，记录最小元素所在的索引，默认为参与选择排序的第一个元素所在的位置
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                //比较最小索引minIndex处的值和j处的值
                if (greater(arr[minIndex], arr[j])) {
                    minIndex = j;
                }
            }
            exchange(arr, i, minIndex);
        }
    }

    public static void exchange(Comparable[] arr, int i, int j) {
        Comparable temp;
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static boolean greater(Comparable c1, Comparable c2) {
        return c1.compareTo(c2) > 0;//c1>c2返回true
    }

}
/*
拿第一个元素和后面的所有元素依次比较，每轮可以选出最小值
begin   4 6 8 7 9 2 10 1
1)      1 6 8 7 9 2 10 4
2)      1 2 8 7 9 6 10 4
3)      1 2 4 7 9 6 10 8

比较次数 (n-1)+(n-2)+(n-3)+...+1 = n^2/2-n/2
交换次数 n-1
*/
