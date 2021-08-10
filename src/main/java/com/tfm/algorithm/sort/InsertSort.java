package com.tfm.algorithm.sort;

/**
 * @ProjectName: algorithm
 * @Package: com.tfm.algorithm.sort
 * @ClassName: InsertSort
 * @Author: tangfengmin
 * @Description: 插入排序
 * @Date: 2021-7-7 15:20
 * @Version: 1.0
 */
public class InsertSort {
    public static void main(String[] args) {
        int params[] = {3, 5, 8, 4, 2, 1, 9, 6, 7};
        int length = params.length;
        for (int i = 1; i < length; i++) {
            for (int j = i; j > 0; j--) {
                if (params[j] < params[j - 1]) {
                    int temp = params[j];
                    params[j] = params[j - 1];
                    params[j - 1] = temp;
                } else {
                    break;
                }
            }
        }
        for (int num : params) {
            System.out.print(num + " ");
        }
    }
}
