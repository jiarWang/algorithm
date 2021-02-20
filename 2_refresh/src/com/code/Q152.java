package com.code;

/**
 * 给你一个整数数组 nums ，
 * 请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 */
public class Q152 {

    public static void main(String[] args) {

    }

    /**
     * dp
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        int preMax = 1, preMin = 1;
        int res = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num < 0) {
                int max = preMax;
                preMax = Math.max(preMin * num, num);
                preMin = Math.min(max * num, num);
            } else {
                preMax = Math.max(preMax * num, num);
                preMin = Math.min(preMin * num, num);
            }
            res = Math.max(res, preMax);
        }
        return res;
    }
}
