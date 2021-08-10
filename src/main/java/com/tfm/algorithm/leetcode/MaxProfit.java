package com.tfm.algorithm.leetcode;

/**
 * @ProjectName: algorithm
 * @Package: com.tfm.algorithm.leetcode
 * @ClassName: MaxProfit
 * @Author: tangfengmin
 * @Description: 买股票的最佳时机
 * @Date: 2021-8-6 15:23
 * @Version: 1.0
 */
public class MaxProfit {
    public static void main(String args){
        int[] nums = {7,1,5,3,6,4};

    }

    /**
     *
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice) {
                minprice = prices[i];
            } else if (prices[i] - minprice > maxprofit) {
                maxprofit = prices[i] - minprice;
            }
        }
        return maxprofit;
    }
}
