package com.code;

import java.util.Arrays;
import java.util.Collections;

/**
 * 5. 最长回文子串
 */
public class Q5 {

    public static void main(String[] args) {

    }

    /**
     * dp
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        if (s == null || s.isEmpty()) return s;
        boolean[][] array = new boolean[s.length()][s.length()];
        for (int i = 0; i < array.length; i++) {
            Arrays.fill(array[i], false);
        }
        String result = "";
        for (int len = 0; len < s.length(); len++) {
            for (int left = 0; left + len < s.length(); left++) {
                int right = left + len;
                if (len == 0) array[left][right] = true;
                else if (len == 1) array[left][right] = s.charAt(left) == s.charAt(right);
                else {
                    array[left][right] = s.charAt(left) == s.charAt(right) && array[left + 1][right - 1];
                }
                if (array[left][right] && len > result.length() - 1){
                    result = s.substring(left, right + 1);
                }
            }
        }
        return result;
    }

    /**
     * 中心拓展法
     *
     * @param s
     * @return
     */
    public String longestPalindrome_(String s) {
      return null;
    }
}


