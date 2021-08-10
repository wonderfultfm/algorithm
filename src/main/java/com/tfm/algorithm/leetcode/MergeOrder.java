package com.tfm.algorithm.leetcode;

/**
 * @ProjectName: algorithm
 * @Package: com.tfm.algorithm.leetcode
 * @ClassName: MergeOrder
 * @Author: tangfengmin
 * @Description: 合并有序数组
 * @Date: 2021-8-6 14:06
 * @Version: 1.0
 */
public class MergeOrder {

    public static void main(String args[]){
        int[] nums1 = {2,5,6,0,0,0};
        int m =6;
        int n=3;
        int[] nums2 = {1,2,3};
    }

    /**
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1, p2 = n - 1;
        int tail = m + n - 1;
        int cur;
        while (p1 >= 0 || p2 >= 0) {
            if (p1 == -1) {
                cur = nums2[p2--];
            } else if (p2 == -1) {
                cur = nums1[p1--];
            } else if (nums1[p1] > nums2[p2]) {
                cur = nums1[p1--];
            } else {
                cur = nums2[p2--];
            }
            nums1[tail--] = cur;
        }
    }
}
