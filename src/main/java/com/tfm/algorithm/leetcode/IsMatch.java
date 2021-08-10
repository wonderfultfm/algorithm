package com.tfm.algorithm.leetcode;

/**
 * @ProjectName: algorithm
 * @Package: com.tfm.algorithm.leetcode
 * @ClassName: IsMatch
 * @Author: tangfengmin
 * @Description: 正则匹配
 * @Date: 2021-7-21 16:49
 * @Version: 1.0
 */
public class IsMatch {


    public static void main(String args[]){
        String s="aaaadf";
        String p="a*df";
        boolean result = isMatch(s,p);
        System.out.print("============"+result);
    }

    /**
     *
     * @param s
     * @param p
     * @return
     */
    public static boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] f = new boolean[m + 1][n + 1];
        f[0][0] = true;
        for (int i = 0; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (p.charAt(j - 1) == '*') {
                    f[i][j] = f[i][j - 2];
                    if (matches(s, p, i, j - 1)) {
                        f[i][j] = f[i][j] || f[i - 1][j];
                    }
                } else {
                    if (matches(s, p, i, j)) {
                        f[i][j] = f[i - 1][j - 1];
                    }
                }
            }
        }
        return f[m][n];
    }

    /**
     *
     * @param s
     * @param p
     * @param i
     * @param j
     * @return
     */
    public static boolean matches(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }
        if (p.charAt(j - 1) == '.') {
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }
}
