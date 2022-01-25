package com.tfm.algorithm.sort;

/**
 * @ProjectName: algorithm
 * @Package: com.tfm.algorithm.sort
 * @ClassName: MergeSort
 * @Author: tangfengmin
 * @Description: 归并排序
 * @Date: 2021-7-7 16:01
 * @Version: 1.0
 */
public class MergeSort {
    /**
     * 递归
     *
     * @param params
     * @param start
     * @param end
     */
    public static void mergerRecursive(int[] params, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = (start + end) / 2;
        mergerRecursive(params, start, mid);
        mergerRecursive(params, mid + 1, end);
        merge(params, start, mid, end);
    }

    /**
     * 合并
     *
     * @param params
     * @param start
     * @param mid
     * @param end
     */
    public static void merge(int[] params, int start, int mid, int end) {
        // 建立一个暂存的数组
        int[] temp = new int[end - start + 1];
        // 取数组两部分开始比较
        int k = start;
        int j = mid + 1;
        int index = 0;
        while (k <= mid && j <= end) {
            if (params[k] > params[j]) {
                temp[index++] = params[j++];
            } else {
                temp[index++] = params[k++];
            }
        }
        // 有可能合并数组的数目并不完全匹配，谁还剩余后面补谁,一定要注意边界问题，多调试几遍
        if (k > mid) {
            while (j <= end) {
                temp[index++] = params[j++];
            }
        } else {
            while (k <= mid) {
                temp[index++] = params[k++];
            }
        }
        System.arraycopy(temp, 0, params, start, end - start + 1);
    }

    public static void main(String[] args) {
        int params[] = {3, 5, 8, 4, 2, 1, 9, 6, 7, 100};
        mergerRecursive(params, 0, params.length - 1);
        for (int num : params) {
            System.out.print(num + " ");
        }
    }
}
