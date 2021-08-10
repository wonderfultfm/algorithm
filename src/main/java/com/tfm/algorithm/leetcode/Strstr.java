package com.tfm.algorithm.leetcode;

/**
 * @ProjectName: algorithm
 * @Package: com.tfm.algorithm.leetcode
 * @ClassName: strStr
 * @Author: tangfengmin
 * @Description: 实现strStr函数
 * @Date: 2021-7-29 14:22
 * @Version: 1.0
 */
public class Strstr {
    public static void main(String args[]){
        String haystack="aaa";
        String needle="ABCDABB";
        int next[] = new int[needle.length()];
        GetNext(needle,next);
    }
    public static int strStr(String haystack, String needle) {
        if("".equals(needle)){
            return 0;
        }
        if("".equals(haystack)){
            return -1;
        }
        if(haystack.length()<needle.length()){
            return -1;
        }
        // 取得needle的第一个元素
        int ans=-1;
        int n = needle.length();
        char c = needle.charAt(0);
        for(int i=0;i<haystack.length();i++){
            char kk = haystack.charAt(i);
            // 一个点到了
            if(kk==c){
                if(i+n<=haystack.length()&&needle.equals(haystack.substring(i,i+n))){
                    ans=i;
                    break;
                }
            }
        }
        return ans;
    }

    /**
     * 尝试手写KMP
     * @param haystack
     * @param needle
     * @return
     */
    public static int kmp(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();
        if(m==0){
            return 0;
        }
        // 定义部分匹配值数组
        int pi[] = new int[needle.length()];
        // 首先计算匹配字符串的部分匹配值
        for (int i = 1, j = 0; i < m; i++) {
            while (j > 0 && needle.charAt(i) != needle.charAt(j)) {
                j = pi[j - 1];
            }
            if (needle.charAt(i) == needle.charAt(j)) {
                j++;
            }
            pi[i] = j;
        }

        return 1;
    }

    public  static void  GetNext(String P, int next[])
    {
        int p_len = P.length();
        int i = 0;
        int j = -1;
        next[0] = -1;

        while (i < p_len)
        {
            if (j == -1 || P.charAt(i) == P.charAt(j))
            {
                i++;
                j++;
                next[i] = j;
            }
            else {
                j = next[j];
            }
        }
    }
    // sunday算法
    public int strStrSunday(String haystack, String needle) {
        // 各种边界情况
        if (haystack != null && haystack.equals(needle)) {
            return 0;
        }
        if (haystack == null || haystack.length() == 0) {
            return -1;
        }
        if (needle == null || needle.length() == 0) {
            return 0;
        }
        int M = haystack.length();
        int N = needle.length();
        for (int i = 0; i <= M - N; i++) {
            int j = 0;
            while (j < N && needle.charAt(j) == haystack.charAt(i + j)) {
                j++;
            }
            if (j == N) {
                return i;
            } else {
                // 前面都属于暴力匹配部分，下面代码在字符串needle中，从后往前寻找第一个与字符haystack.charAt(i + N)相等的字符，
                // 从而获得下一个合适的i，目的是尽量增加每一次的移动步数。
                int k = N - 1;
                while (k >= 0 && i + N < M && needle.charAt(k) != haystack.charAt(i + N)) {
                    k--;
                }
                if (k < 0) {
                    i = i + N;
                } else {
                    i = i + N - 1 - k;
                }
            }
        }
        return -1;
    }

    public int sundaybyself(String haystack, String needle){
        if("".equals(needle)||haystack.equals(needle)){
            return 0;
        }
        if("".equals(haystack)){
            return -1;
        }
        if(haystack.length()<needle.length()){
            return -1;
        }
        int m= haystack.length();
        int n= needle.length();
        for(int i=0;i<m-n;i++){
            int j=0;
            while(j<n&&haystack.charAt(i+j)==needle.charAt(j)){
                j++;
            }
            if(j==n){
                return i;
            }else{
                int k = n-1;
                while(k>0&&needle.charAt(k)!=haystack.charAt(i+n)){
                    k--;
                }
                if(k<0){
                    i=i+n;
                }else{
                    i=i+n-1-k;
                }
            }
        }
        return -1;
    }
}
