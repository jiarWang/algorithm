package com.code;

public class Q1143 {
    public static void main(String[] args) {

    }

    public int longestCommonSubsequence(String text1, String text2) {
        int[][] nums = new int[text1.length() + 1][text2.length() + 1];
        for (int i = 0; i < text1.length(); i++) {
            for (int j = 0; j < text2.length(); j++) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    nums[i + 1][j + 1] = nums[i - 1][j - 1] + 1;
                }else {
                    nums[i + 1][j + 1] = Math.max(nums[i][j + 1], nums[i + 1][j]);
                }
            }
        }
        return nums[text1.length()][text2.length()];
    }
}
