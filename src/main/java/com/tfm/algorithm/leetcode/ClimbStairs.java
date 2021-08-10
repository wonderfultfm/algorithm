package com.tfm.algorithm.leetcode;

/**
 * @ProjectName: algorithm
 * @Package: com.tfm.algorithm.leetcode
 * @ClassName: ClimbStairs
 * @Author: tangfengmin
 * @Description: 爬楼梯
 * @Date: 2021-8-5 14:41
 * @Version: 1.0
 */
public class ClimbStairs {
    public static void main(String args[]){
        int result = climbStairstwo(45);
        System.out.print("----------------"+result);
    }

    /**
     * 动态规划
     * @param n
     * @return
     */
    public static int climbStairs(int n){
        if(n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }
        int result = climbStairs(n-1)+climbStairs(n-2);
        return result;
    }
    public static int climbStairstwo(int n){
        if(n==1||n==2){
            return n;
        }
        int i1=1;
        int i2=2;
        for(int i=3;i<=n;i++){
            int temp = i1+i2;
            i1 = i2;
            i2 = temp;
        }
        return i2;
    }
}
