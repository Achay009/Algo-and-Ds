package com.company;

import java.util.Stack;

public class MinimumAddToMakeValid {
    public static void solution(String s){
        Stack<Integer> stack = new Stack<>();
        char[] charArray = s.toCharArray();
        int count = 0;

        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == '(') {
                stack.push(i);
            }
            if (charArray[i] == ')') {
                if (stack.isEmpty()) {
                    count++;
                }
                if (!stack.isEmpty()){
                    stack.pop();
                }
            }
        }
        System.out.println("Minimum add to make Valid Parentheses "+stack.size() + count);
    }
}
