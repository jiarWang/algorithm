package com.code;

import com.sun.deploy.util.ArrayUtil;

import java.util.Arrays;

/**
 * 5. 最长回文子串
 */
public class Q5 {
    public static void main(String[] args) {
        System.out.println(longestSubString("aafdasdffdsasafdfa"));
    }

    public static String longestSubString(String str){
        if (str == null || str.isEmpty()) return str;
        boolean[][] array = new boolean[str.length()][str.length()];
        String resultStr = "";
        //[start, start + len]
        for (int len = 0; len < str.length(); len++) {
            for (int start = 0; start + len < str.length(); start++) {
                int right = start + len;
                 if (len <= 1){
                    array[start][right] = str.charAt(start) == str.charAt(right);
                }
                else {
                    array[start][right] = array[start + 1][right - 1] && str.charAt(start) == str.charAt(right);
                }
                if (array[start][right] && resultStr.length() < len + 1){
                    resultStr = str.substring(start, right + 1);
                }
            }
        }
        return resultStr;
    }
}
