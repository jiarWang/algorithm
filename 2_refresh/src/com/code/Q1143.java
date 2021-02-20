package com.code;

/**
 * 最长公共子序列
 */
public class Q1143 {
    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("abcde", "ace"));
    }

    public static int longestCommonSubsequence(String text1, String text2) {
        if (text1 == null || text2 == null) return 0;
        int[][] subLen = new int[text1.length() + 1][text2.length() + 1];
        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                boolean same = text1.charAt(i - 1) == text2.charAt(j - 1);
                if (!same) subLen[i][j] = Math.max(subLen[i - 1][j], subLen[i][j - 1]);
                else subLen[i][j] = subLen[i - 1][j - 1] + 1;
            }
        }
        return subLen[text1.length()][text2.length()];
    }
}
