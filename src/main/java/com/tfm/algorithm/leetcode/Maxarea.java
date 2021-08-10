package com.tfm.algorithm.leetcode;

/**
 * @ProjectName: algorithm
 * @Package: com.tfm.algorithm.leetcode
 * @ClassName: Maxarea
 * @Author: tangfengmin
 * @Description: 盛水最多的容器
 * @Date: 2021-7-28 9:23
 * @Version: 1.0
 */
public class Maxarea {

    public static void main(String args[]){
        int[] height={2,3,4,5,18,17,6};
        System.out.print("----------------"+Maxarea(height));
    }

    /**
     * 双指针
     * @param height
     * @return
     */
    public static int Maxarea(int[] height){
        if(height.length<=1){
            return 0;
        }
        int left=0;
        int right=height.length-1;
        int max=0;
        while(left<right){
            int dd=Math.min(height[left],height[right])*(right-left);
            if(height[left]>=height[right]){
                right--;
            }else{
                left++;
            }
            max=Math.max(max,dd);
        }
        return max;
    }
}
