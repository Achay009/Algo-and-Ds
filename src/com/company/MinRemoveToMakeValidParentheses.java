package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MinRemoveToMakeValidParentheses {
    public static void solution(String s) {
        Stack<Integer> stack = new Stack<>();
        char[] charArray = s.toCharArray();

        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == '(') {
                stack.push(i);
            }
            if (charArray[i] == ')') {
                if (stack.isEmpty()) {
                    charArray[i] = ' ';
                    continue;
                }
                stack.pop();
            }
        }

        for(int position : stack){
            charArray[position] = ' ';
        }

        String result = "";
        for(char str : charArray){
            if (str == ' ')continue;
            result += String.valueOf(str);
        }

        System.out.println("Minimum Remove to valid Parentheses : " + result);
    }
}
