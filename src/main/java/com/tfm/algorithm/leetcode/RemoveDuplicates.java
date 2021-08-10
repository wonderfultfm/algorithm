package com.tfm.algorithm.leetcode;

/**
 * @ProjectName: algorithm
 * @Package: com.tfm.algorithm.leetcode
 * @ClassName: RemoveDuplicates
 * @Author: tangfengmin
 * @Description: 去掉重复数值
 * @Date: 2021-7-29 11:00
 * @Version: 1.0
 */
public class RemoveDuplicates {

    /**
     * 快慢双指针
     * @param nums
     * @return
     */
    public static int removeDuplicates(int[] nums) {
        if(nums.length==0||nums.length==1){
            return nums.length;
        }
        int slow=1;
        for(int fast=1;fast<nums.length;fast++){
            if(nums[fast]!=nums[fast-1]){
                nums[slow]=nums[fast];
                slow++;
            }
        }
        return slow;
    }
}
