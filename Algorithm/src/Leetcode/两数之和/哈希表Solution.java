package Leetcode.两数之和;

import java.util.HashMap;

/**
 * @version v1.0
 * @className: 哈希表Solution
 * @description: TODO 类描述
 * @author: Orange
 **/
public class 哈希表Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i <nums.length ; i++) {
            if (map.containsKey(target-nums[i])){
                return new int[]{map.get(target-nums[i]),i};
            }
            map.put(nums[i],i);
        }
        return null;
    }
}

/*
* 考虑将数据存储在hashmap中，这样可以直接判断map中是否包含`x`。省去一层循环。
* 对于每一个 `x`，我们首先查询哈希表中是否存在 `target - x`，然后将 `x` 插入到哈希表中，即可保证不会让 `x` 和自己匹配。
* 这里牺牲了内存占用，节约了时间。
*
* 时间复杂度：O(N)，其中 N 是数组中的元素数量。对于每一个元素 x，我们可以 O(1) 地寻找 target - x。
* 空间复杂度：O(N)，其中 N 是数组中的元素数量。主要为哈希表的开销。
* */
