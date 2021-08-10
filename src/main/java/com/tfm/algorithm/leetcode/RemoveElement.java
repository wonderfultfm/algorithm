package com.tfm.algorithm.leetcode;

/**
 * @ProjectName: algorithm
 * @Package: com.tfm.algorithm.leetcode
 * @ClassName: RemoveElement
 * @Author: tangfengmin
 * @Description: 移除元素
 * @Date: 2021-7-29 13:09
 * @Version: 1.0
 */
public class RemoveElement {
    public static void main(String args[]) {
        int[] nums = {3, 2, 2, 3};
        int val = 3;
        int result = removeElement(nums, val);
        System.out.print("--------------" + result);
    }

    public static int removeElement(int[] nums, int val) {
        if (nums.length == 0) {
            return nums.length;
        }
        int slow = 0;
        int fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }
}
