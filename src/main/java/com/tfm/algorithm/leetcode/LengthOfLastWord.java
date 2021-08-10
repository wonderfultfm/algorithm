package com.tfm.algorithm.leetcode;

/**
 * @ProjectName: algorithm
 * @Package: com.tfm.algorithm.leetcode
 * @ClassName: LengthOfLastWord
 * @Author: tangfengmin
 * @Description: 最后一个单词的长度
 * @Date: 2021-7-30 15:55
 * @Version: 1.0
 */
public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        int ans =0;
        char[] char1 = " ".toCharArray();
        char char2 = char1[0];
        int flag=0;
        int max=s.length();
        for(int j=s.length()-1;j>=0;j--){
            if(s.charAt(j)==char2&&flag==0){
                max--;
                continue;
            }
            if(s.charAt(j)==char2&&flag==1){
                ans = max-1-j;
                break;
            }
            if(s.charAt(j)!=char2){
                flag=1;
            }
            if(j==0){
                ans=max;
                break;
            }
        }
        return ans;
    }
}
