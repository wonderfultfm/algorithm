package com.tfm.algorithm.leetcode;

import java.math.BigDecimal;

/**
 * @ProjectName: algorithm
 * @Package: com.tfm.algorithm.leetcode
 * @ClassName: Median
 * @Author: tangfengmin
 * @Description: 寻找两个正序数组的中位数
 * @Date: 2021-7-14 15:39
 * @Version: 1.0
 */
public class Median {
    public static void main(String args[]) {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        System.out.println("----------" + median(nums1, nums2));
    }

    /**
     * 寻找两个正序数组的中位数
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static double median(int[] nums1, int nums2[]) {
        int[] result = new int[nums1.length + nums2.length];
        if (nums1.length == 0) {
            result = nums2;
        } else if (nums2.length == 0) {
            result = nums1;
        } else {
            int i = 0;
            int j = 0;
            int k = 0;
            while (i <= nums1.length - 1 && j <= nums2.length - 1) {
                if (nums1[i] <= nums2[j]) {
                    result[k++] = nums1[i++];
                } else if (nums1[i] > nums2[j]) {
                    result[k++] = nums2[j++];
                }
            }
            // 如果1数组还有
            if (i < nums1.length) {
                while (k < nums1.length + nums2.length) {
                    result[k++] = nums1[i++];
                }
            }
            // 如果2数组还有
            if (j < nums2.length) {
                while (k < nums1.length + nums2.length) {
                    result[k++] = nums2[j++];
                }
            }
        }
        // 求中位数方法
        if (nums1.length + nums2.length == 0) {
            return 0;
        } else if ((nums1.length + nums2.length) % 2 == 0) {
            Double a = new Double(result[(nums1.length + nums2.length) / 2]);
            Double b = new Double(result[(nums1.length + nums2.length) / 2 - 1]);
            return (a + b) / 2;
        } else {
            return result[(nums1.length + nums2.length) / 2];
        }
    }
}
