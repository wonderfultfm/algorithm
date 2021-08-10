package com.tfm.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName: algorithm
 * @Package: com.tfm.algorithm.leetcode
 * @ClassName: Twosum
 * @Author: tangfengmin
 * @Description: 两数之和
 * @Date: 2021-7-9 17:19
 * @Version: 1.0
 */
public class Twosum {
    public int[] twosum(int[] nums, int target) {
        Map<Integer, Integer> hashtable = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; ++i) {
            if (hashtable.containsKey(target - nums[i])) {
                return new int[] {hashtable.get(target - nums[i]), i};
            }
            hashtable.put(nums[i], i);
        }
        return new int[0];
    }
}
