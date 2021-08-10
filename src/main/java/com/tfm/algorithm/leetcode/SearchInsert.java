package com.tfm.algorithm.leetcode;

/**
 * @ProjectName: algorithm
 * @Package: com.tfm.algorithm.leetcode
 * @ClassName: SearchInsert
 * @Author: tangfengmin
 * @Description: 搜索插入位置
 * @Date: 2021-7-30 15:22
 * @Version: 1.0
 */
public class SearchInsert {
    public static void main(String args[]){
        int[] nums = {1,3};
        int target = 2;
        int result = searchInsert(nums,target);
        System.out.print("------------------"+result);
    }
    /**
     *
     * @param nums
     * @param target
     * @return
     */
    public static int searchInsert(int[] nums, int target) {
        int left = 0;
        int right= nums.length-1;
        if(target<nums[0]||nums.length==0){
            return 0;
        }
        if(target>nums[nums.length-1]){
            return nums.length;
        }
        while(left<=right){
            int mid = left + (right-left)/2;
            if(nums[mid]==target){
                return mid;
            }else if(nums[mid]<target){
                left = mid +1;
                if(nums[left]>target){
                    return left;
                }
            }else if(nums[mid]>target){
                right= mid -1;
                if(nums[right]<target){
                    return right+1;
                }
            }
        }
        return -1;
    }
}
