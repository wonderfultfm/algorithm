package com.tfm.algorithm.sort;

/**
 * @ProjectName: algorithm
 * @Package: com.tfm.algorithm.sort
 * @ClassName: ChooseSort
 * @Author: tangfengmin
 * @Description: 选择排序
 * @Date: 2021-7-7 14:11
 * @Version: 1.0
 */
public class ChooseSort {
    public static void main(String[] args){
        int params[] = {3,5,8,4,2,1,9,6};
        int length = params.length;
        for(int i=0;i<length;i++){
            int minindex = i;
            for(int j=i;j<length;j++){
                if(params[minindex]>params[j]){
                    minindex = j;
                }
            }
            if(minindex!=i){
                int temp = params[i];
                params[i] = params[minindex];
                params[minindex] = temp;
            }
        }
        for(int num:params){
            System.out.print(num+" ");
        }
    }
}
