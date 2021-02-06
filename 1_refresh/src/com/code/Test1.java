package com.code;

import java.util.HashMap;
import java.util.Stack;

public class Test1 {
    public static void main(String[] args) {
        System.out.println(legalBracket("[({()[{}{}]})]("));
        System.out.println(legalBracket("[({()[{}{}]})]"));
        System.out.println(legalBracket("[({()[{}{[}]})]"));
    }

    public static final boolean legalBracket(String s) {
        if (s == null || s.length() == 0) return true;
        char[] chars = s.toCharArray();
        Stack<String> stack = new Stack<>();
        HashMap<String, String> map = new HashMap<>();
        map.put(")", "(");
        map.put("}", "{");
        map.put("]", "[");
        for (char c : chars) {
            String str = String.valueOf(c);
            if (map.values().contains(str)){
                stack.push(str);
            }else if (map.keySet().contains(str)){
                if (!stack.pop().equals(map.get(str)))return false;
            }
        }
        return stack.empty();
    }
}
