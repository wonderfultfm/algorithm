package com.tfm.algorithm.sort;

/**
 * @ProjectName: algorithm
 * @Package: com.tfm.algorithm.sort
 * @ClassName: BubbleSort
 * @Author: tangfengmin
 * @Description: 冒泡排序
 * @Date: 2021-7-7 13:50
 * @Version: 1.0
 */
public class BubbleSort {
    public static void main(String[] args) {
        int params[] = {3, 5, 8, 4, 2, 1, 9, 6};
        int length = params.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                if (params[j] > params[j + 1]) {
                    int temp = params[j];
                    params[j] = params[j + 1];
                    params[j + 1] = temp;
                }
            }
        }
        for (int num : params) {
            System.out.print(num + " ");
        }
    }
}
