package com.tfm.algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @ProjectName: algorithm
 * @Package: com.tfm.algorithm.leetcode
 * @ClassName: Palindrome
 * @Author: tangfengmin
 * @Description: 回文字符串
 * @Date: 2021-7-16 14:15
 * @Version: 1.0
 */
public class Palindrome {

    public static void main(String args[]) {
        String demo = "abba";
        String result = longestPalindrome(demo);
        System.out.println("----------------" + result);
    }

    /**
     *
     *
     * @param s
     * @return
     */
    public static String palindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }

        int maxLen = 1;
        int begin = 0;
        // dp[i][j] 表示 s[i..j] 是否是回文串
        boolean[][] dp = new boolean[len][len];
        // 初始化：所有长度为 1 的子串都是回文串
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        char[] charArray = s.toCharArray();
        // 递推开始
        // 先枚举子串长度
        for (int L = 2; L <= len; L++) {
            // 枚举左边界，左边界的上限设置可以宽松一些
            for (int i = 0; i < len; i++) {
                // 由 L 和 i 可以确定右边界，即 j - i + 1 = L 得
                int j = L + i - 1;
                // 如果右边界越界，就可以退出当前循环
                if (j >= len) {
                    break;
                }

                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                // 只要 dp[i][L] == true 成立，就表示子串 s[i..L] 是回文，此时记录回文长度和起始位置
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    public static String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        // 保存起始位置，测试了用数组似乎能比全局变量稍快一点
        int[] range = new int[2];
        char[] str = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            // 把回文看成中间的部分全是同一字符，左右部分相对称
            // 找到下一个与当前字符不同的字符
            i = findLongest(str, i, range);
        }
        return s.substring(range[0], range[1] + 1);
    }

    public static int findLongest(char[] str, int low, int[] range) {
        // 查找中间部分
        int high = low;
        while (high < str.length - 1 && str[high + 1] == str[low]) {
            high++;
        }
        // 定位中间部分的最后一个字符
        int ans = high;
        // 从中间向左右扩散
        while (low > 0 && high < str.length - 1 && str[low - 1] == str[high + 1]) {
            low--;
            high++;
        }
        // 记录最大长度
        if (high - low > range[1] - range[0]) {
            range[0] = low;
            range[1] = high;
        }
        return ans;
    }

    // manachar方法：面试加分项
    public String longestPalindromeManacher(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        // 将s转换为加了特殊字符#的字符数组，目的是统一奇偶数的回文中心差异性问题
        // 比如：s=”cabac“转化为cs=[#c#a#b#a#c#]
        char[] cs = manacherString(s, len);
        // pArr[i]是cs[i]每个位置的最大回文半径
        // 比如：cs=[#c#a#b#a#c#]，pArr=[1,2,1,2,1,6,1,2,1,2,1]
        int[] pArr = new int[cs.length];
        // pR是cs[i]每个位置的回文右边界的下一个位置
        // 比如：cs=[#c#a#b#a#c#]，pR=1,3,3,5,5,11(此时pR第一次遍历完cs，之后的pR可以不再更新),11,11,11,11,11
        int pR = -1;
        // index是最近更新pR时的回文中心位置
        // 比如：cs=[#c#a#b#a#c#]，index=0,1,1,3,3,5(之后pR不再更新，index也不再更新),5,5,5,5,5
        int index = -1;
        // max记录pArr[i]中最大值：pArr[i]最大值就能算出原字符串的最长回文子串长度
        int maxLen = Integer.MIN_VALUE;
        int centerIndex = Integer.MIN_VALUE;
        int begin = 0;
        for (int i = 0; i != cs.length; i++) {
            // 第一句代码:每轮循环时,i至少不需要验证的区域,先给到pArr[i],解释如下:
            // pR<=i:i超过了pR，无法优化，不用验证的区域就是pArr[i]本事=回文半径为1
            // pR>i:i没有超过pR，可以优化，至少不需要验的区域：Math.min(pArr[2 * index - i], pR - i)
            pArr[i] = pR > i ? Math.min(pArr[2 * index - i], pR - i) : 1;
            // 第二句代码:在i位置尝试往外扩最长回文半径长度pArr[i]:
            // 如果扩成功pArr[i]++;否则立刻停止扩的过程break
            while (i + pArr[i] < cs.length && i - pArr[i] >= 0) {
                if (cs[i + pArr[i]] == cs[i - pArr[i]]) {
                    pArr[i]++;
                } else {
                    break;
                }
            }
            // 每轮循环,扩的长度超过回文右边界下一个位置，就更新pR和index
            if (i + pArr[i] > pR) {
                pR = i + pArr[i];
                index = i;
            }
        }
        // 找出cs中回文半径最大值maxLen和其对应的数组索引centerInter
        for (int i = 0; i < cs.length; i++) {
            if (pArr[i] > maxLen) {
                maxLen = pArr[i];
                centerIndex = i;
            }
        }
        // 根据cs中回文半径和对应坐标算原字符串中的最大回文长度和最大回文中心
        // 原字符串最大回文长度：maxLen-1，比如#a#b#a#，b的回文半径=4，那么原aba的最长回文子串长度为3
        maxLen = maxLen - 1;
        // 原字符串最大回文串中心：(centerIndex - 1)/2，比如#a#b#a#，b的centerIndex=4；那么原aba的b的坐标为(4-1)/2
        centerIndex = (centerIndex - 1) / 2;
        // 根据centerIndex和maxLen算最大回文串begin下标
        // 奇数：centerIndex-maxLen/2
        // 偶数：centerIndex-maxLen/2+1
        // 统一：centerIndex-(maxLen-1)/2
        begin = centerIndex - (maxLen - 1) / 2;
        return s.substring(begin, begin + maxLen);
    }

    // 将str转换成带#号的字符数组:解决奇数、偶数中心往外扩的差异性
    public static char[] manacherString(String s, int n) {
        char[] charArr = s.toCharArray();
        int index = 0;// index遍历charArr
        // s:a -> res:#a#，长度1 -> 3，奇数位放#，偶数位放原字符
        // s:ab -> res:#a#b#，长度2 -> 5，奇数位放#，偶数位放原字符
        // s:aba -> res:#a#b#a#，长度3 -> 7，奇数位放#，偶数位放原字符
        // 长度变化规律:len -> len+len+1=len*2+1，奇数位放#，偶数位放原字符
        char[] res = new char[n * 2 + 1];
        for (int i = 0; i != res.length; i++) {
            // 偶数位放#，奇数位放原字符
            res[i] = (i & 1) == 0 ? '#' : charArr[index++];
        }
        return res;
    }
}
