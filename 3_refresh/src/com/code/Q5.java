package com.code;
//给你一个字符串 s，找到 s 中最长的回文子串。
//
//
//
// 示例 1：
//
//
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
//
//
// 示例 2：
//
//
//输入：s = "cbbd"
//输出："bb"
public class Q5 {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
    }
    public static String longestPalindrome(String s) {
        if(s == null || s.isEmpty()) return "";
        boolean[][] dp = new boolean[s.length()][s.length()];
        String result = "";

        for (int len = 0; len < s.length(); len++) {
            for (int start = 0; start + len < s.length(); start++){
                int right = start + len;
                if (len <= 1){
                    dp[start][right] = s.charAt(start) == s.charAt(right);
                }else {
                    dp[start][right] =  s.charAt(start) == s.charAt(right) &&  dp[start + 1][right - 1];
                }
                if (dp[start][right] && result.length() < len){
                    result = s.substring(start, right + 1);
                }
            }
        }
        return result;
    }
}
