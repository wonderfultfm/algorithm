package com.tfm.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @ProjectName: algorithm
 * @Package: com.tfm.algorithm.leetcode
 * @ClassName: IsValid
 * @Author: tangfengmin
 * @Description: 判断字符串是否有效
 * @Date: 2021-7-28 16:49
 * @Version: 1.0
 */
public class IsValid {
    public static void main(String args[]){

    }
    public boolean isValid(String s) {
        if(s.length()%2==1){
            return false;
        }
        boolean result = true;
        Map<Character,Character> pairs = new HashMap<>();
        pairs.put(')','(');
        pairs.put('}','{');
        pairs.put(']','[');
        Stack<Character> stack = new Stack();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(pairs.containsKey(c)){
                if(stack.isEmpty()){
                    result = false;
                    return result;
                }
                if(stack.peek().equals(pairs.get(c))){
                    stack.pop();
                }else{
                    result = false;
                    return result;
                }
            }else{
                stack.push(c);
            }
        }
        if(!stack.isEmpty()){
            result=false;
            return result;
        }
        return result;
    }
}
