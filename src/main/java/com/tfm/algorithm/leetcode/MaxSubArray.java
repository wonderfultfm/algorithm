package com.tfm.algorithm.leetcode;

/**
 * @ProjectName: algorithm
 * @Package: com.tfm.algorithm.leetcode
 * @ClassName: maxSubArray
 * @Author: tangfengmin
 * @Description: 最大子序和
 * @Date: 2021-7-30 16:23
 * @Version: 1.0
 */
public class MaxSubArray {
    public static void main(String args[]){
        int[]  nums = {-2,1,-3,4,-1,2,1,-5,4};
        int result = maxSubArray(nums);
        System.out.print("---------"+result);
    }

    /**
     * 动态规划
     * 状态转移方程 max(nums[i],f(i-1))
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }
}
