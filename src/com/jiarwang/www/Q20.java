package com.jiarwang.www;

import java.util.Stack;

public class Q20 {
    public boolean isValid(String s) {
        if (s == null) return true;
        Stack<Integer> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            switch (c){
                case '(':
                case '{':
                case '[':
                    stack.push(0 + c);
                    break;
                case ')':
                    if (stack.isEmpty() || stack.pop() - '(' != 0) return false;
                    break;
                case '}':
                    if (stack.isEmpty() || stack.pop() - '{' != 0) return false;
                    break;
                case ']':
                    if (stack.isEmpty() ||stack.pop() - '[' != 0) return false;
                    break;
            }
        }
        return stack.isEmpty();
    }
}
