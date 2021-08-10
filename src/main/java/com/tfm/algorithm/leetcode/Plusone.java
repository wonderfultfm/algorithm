package com.tfm.algorithm.leetcode;

/**
 * @ProjectName: algorithm
 * @Package: com.tfm.algorithm.leetcode
 * @ClassName: Plusone
 * @Author: tangfengmin
 * @Description: 加一
 * @Date: 2021-8-5 14:08
 * @Version: 1.0
 */
public class Plusone {
    public static void main(String[] args) {
        int[] digits = {1, 2, 3};
        int[] result = plusone(digits);
        System.out.print("------" + result.toString());
    }

    public static int[] plusone(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) {
                return digits;
            }
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}
