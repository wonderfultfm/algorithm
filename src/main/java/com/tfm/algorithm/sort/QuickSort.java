package com.tfm.algorithm.sort;

/**
 * @ProjectName: algorithm
 * @Package: com.tfm.algorithm.sort
 * @ClassName: QuickSort
 * @Author: tangfengmin
 * @Description: 快速排序
 * @Date: 2021-7-7 17:54
 * @Version: 1.0
 */
public class QuickSort {
    /**
     * 递归
     * @param params
     * @param leftIndex
     * @param rightIndex
     */
    public static void quick(int[] params,int leftIndex,int rightIndex){
        // 声明局部变量替换传参
        int left = leftIndex;
        int right = rightIndex;
        if(leftIndex>rightIndex){
            return;
        }
        // 基准值
        int temp = params[leftIndex];
        // 步入循环
        while(left<right){
            // 注意边界
            while(temp<=params[right]&&left<right){
                right--;
            }
            // 注意边界
            while(temp>=params[left]&&left<right){
                left++;
            }
            if(left<right){
                int tma = params[left];
                params[left] = params[right];
                params[right] = tma;
            }
        }
        // 最后交换基准位
        int tmb = params[left];
        params[left] = params[leftIndex];
        params[leftIndex] = tmb;
        // 左部继续递归
        quick(params,leftIndex,left-1);
        // 右部继续递归
        quick(params,left+1,rightIndex);
    }

    public static void main(String args[]){
        int params[] = {3,5,8,4,2,1,9,6,7};
        quick(params,0,params.length-1);
        for(int num:params){
            System.out.print(num+" ");
        }
    }
}
