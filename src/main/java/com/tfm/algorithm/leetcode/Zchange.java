package com.tfm.algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ProjectName: algorithm
 * @Package: com.tfm.algorithm.leetcode
 * @ClassName: Zchange
 * @Author: tangfengmin
 * @Description: Z型变换
 * @Date: 2021-7-16 13:10
 * @Version: 1.0
 */
public class Zchange {

    public static void main(String args[]) {
        String demo = "PAHNAPLSIIGYIR";
        String result = zchange(demo, 4);
        System.out.println(result);
    }

    /**
     * 思路，指针数组 加Hashmap
     *
     * @param s
     * @return
     */
    public static String zchange(String s, int numRows) {
        // 一列就别费事了
        if (numRows == 1) {
            return s;
        }
        // 定义存数据的数组 指针为行
        HashMap<Integer, Queue> map = new HashMap();
        int index = 0;
        // 指针往返正逆向标志
        int flag = 1;
        for (int i = 0; i < s.length(); i++) {
            if (map.get(index) == null) {
                Queue<String> queue = new LinkedList<>();
                queue.add(s.charAt(i) + "");
                map.put(index, queue);
            } else {
                Queue<String> queue = map.get(index);
                queue.add(s.charAt(i) + "");
                map.put(index, queue);
            }
            // 重新回置
            if (index == 0) {
                flag = 1;
            }
            if (index == numRows - 1) {
                flag = 0;
            }
            if (flag == 1) {
                index++;
            } else {
                index--;
            }
        }
        // 取出来打印
        String result = "";
        for (int i = 0; i < numRows; i++) {
            if (map.get(i) != null) {
                Queue<String> queue = map.get(i);
                for (String q : queue) {
                    result = result + q;
                }
            }
        }
        return result;
    }

    /**
     * 正解
     *
     * @param s
     * @param numRows
     * @return
     */
    public static String zchangeZJ(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++) {
            rows.add(new StringBuilder());
        }
        int curRow = 0;
        boolean goingDown = false;
        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows - 1) {
                goingDown = !goingDown;
            }
            curRow += goingDown ? 1 : -1;
        }
        StringBuilder ret = new StringBuilder();
        for (StringBuilder row : rows) {
            ret.append(row);
        }
        return ret.toString();
    }
}
