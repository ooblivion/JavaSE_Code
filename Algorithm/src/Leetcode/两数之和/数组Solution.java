package Leetcode.两数之和;

/**
 * @version v1.0
 * @className: 数组Solution
 * @description: 双重for循环，暴力查找，有没有相加==target的
 * @author: Orange
 **/
public class 数组Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ints = new int[2];
        outer:  for (int i = 0; i <nums.length ; i++) {
            //内层for循环从i+1开始，因为同一个元素不能使用两遍。
            for (int j = i+1; j <nums.length ; j++) {
                if (target-nums[i]==nums[j]){
                    ints[0]=i;
                    ints[1]=j;
                    //找到解后就可以break退出，因为只有一个解。（有无break运行时间相差近10s）
                    break outer;
                }
            }
        }
        return ints;
    }
}
/*
* 时间复杂度：O(N^2)，其中 N 是数组中的元素数量。最坏情况下数组中任意两个数都要被匹配一次。
* 空间复杂度：O(1)
* */