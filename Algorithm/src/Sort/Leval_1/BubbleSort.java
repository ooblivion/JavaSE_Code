package Sort.Leval_1;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        //int[] arr = {4, 5, 6, 3, 2, 1};
        Integer[] arr_i = {4, 5, 6, 3, 2, 1};//包装类内部实现了comparable接口
        BubbleSort.Bubblesort(arr_i);
//        for(Comparable c : arr_i){
//            System.out.print(c+" ");
//        }
        System.out.println(Arrays.toString(arr_i));
    }

    //位运算交换两元素的位置，不会占用额外空间
    public static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    //TimeComplexity O(n^2)
    public static void Bubblesort(Comparable[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (greater(arr[j], arr[j + 1])) {//(n-1)+(n-2)+(n-3)+...+1 = n^2/2-n/2
                    exchange(arr, j, j + 1);//(n-1)+(n-2)+(n-3)+...+1 = n^2/2-n/2
                }
            }
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
比较相邻元素，每轮可以选出最大值
begin   4 5 6 3 2 1
1)      4 5 3 2 1 6
2)      4 3 2 1 5 6
3)      3 2 1 4 5 6
4)      2 1 3 4 5 6
5)      1 2 3 4 5 6
6)      1 2 3 4 5 6
比较次数 (n-1)+(n-2)+(n-3)+...+1 = n^2/2-n/2
交换次数 (n-1)+(n-2)+(n-3)+...+1 = n^2/2-n/2
*/