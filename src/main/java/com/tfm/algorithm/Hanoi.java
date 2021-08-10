package com.tfm.algorithm;

/**
 * @ProjectName: algorithm
 * @Package: com.tfm.algorithm
 * @ClassName: Hanoi
 * @Author: tangfengmin
 * @Description: 汉诺塔
 * @Date: 2021-7-9 15:48
 * @Version: 1.0
 */
public class Hanoi {
    public static int count=1;

    public static void main(String args[]) {
        hanio(4, "A", "B", "C");
    }

    /**
     *
     * @param n
     * @param A
     * @param B
     * @param C
     */
    public static void hanio(int n, String A, String B, String C) {
        if (n < 1) {
            System.out.println("汉诺塔的层数不得小于一");
        } else if (n == 1) {
            // 递归出口
            System.out.println("移动：" + A + "——》" + C+"-------"+count++);
            return;
        } else {
            // 核心移动三步
            hanio(n - 1, A, C, B);
            System.out.println("移动：" + A + "——》" + C+"-------"+count++);
            hanio(n - 1, B, A, C);
        }
    }
}
