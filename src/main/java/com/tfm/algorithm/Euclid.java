package com.tfm.algorithm;

/**
 * @ProjectName: algorithm
 * @Package: com.tfm.algorithm
 * @ClassName: Euclid
 * @Author: tangfengmin
 * @Description: 欧几里得算法最大公约数
 * @Date: 2021-7-9 10:50
 * @Version: 1.0
 */
public class Euclid {
    /**
     *
     * @param a
     * @param b
     * @return
     */
    public static int getEuclid(int a, int b) {
        int result = 1;
        int k = a;
        int j = b;
        while (result != 0) {
            result = k % j;
            k = j;
            j = result;
        }
        return k;
    }

    public static void main(String args[]) {
        int result = getEuclid(1112, 695);
        System.out.println("最大公约数为" + result);
    }

}
