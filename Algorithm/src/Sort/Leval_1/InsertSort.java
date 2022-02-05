package Sort.Leval_1;

import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {
        Integer[] arr_i = {4, 5, 6, 3, 2, 1};//包装类内部实现了comparable接口
        InsertSort.InsertSort(arr_i);
        System.out.println(Arrays.toString(arr_i));
    }
    public static void InsertSort(Comparable[] arr){
        for(int i = 1; i<arr.length; i++){
            for(int j = i; j>0; j--){
                if(greater(arr[j-1], arr[j])){
                    exchange(arr,j-1, j);
                }else
                    break;
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
//add new thing

