package com.tfm.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName: algorithm
 * @Package: com.tfm.algorithm.leetcode
 * @ClassName: IntToRoman
 * @Author: tangfengmin
 * @Description: 整数转罗马数字,罗马数字转整数
 * @Date: 2021-7-28 10:10
 * @Version: 1.0
 */
public class IntToRoman {
    static int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    static String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    static Map<Character, Integer> symbolValues = new HashMap<Character, Integer>() {{
        put('I', 1);
        put('V', 5);
        put('X', 10);
        put('L', 50);
        put('C', 100);
        put('D', 500);
        put('M', 1000);
    }};

    public static void main(String args[]){

    }

    public static String intoRoman(int num){
        StringBuffer roman = new StringBuffer();
        for (int i = 0; i < values.length; ++i) {
            int value = values[i];
            String symbol = symbols[i];
            while (num >= value) {
                num -= value;
                roman.append(symbol);
            }
            if (num == 0) {
                break;
            }
        }
        return roman.toString();
    }

    public static int romanToInt(String roman){
        int ans = 0;
        int n = roman.length();
        for (int i = 0; i < n; ++i) {
            int value = symbolValues.get(roman.charAt(i));
            if (i < n - 1 && value < symbolValues.get(roman.charAt(i + 1))) {
                ans -= value;
            } else {
                ans += value;
            }
        }
        return ans;
    }
}
