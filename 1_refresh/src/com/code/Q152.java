package com.code;

import java.util.Arrays;

/**
 * 乘积最大子序列
 *
 * 动态规划
 */
public class Q152 {

    public static void main(String[] args) {

    }

    public  int  maxProductSubArray(int[] nums){
        int[] min = new int[nums.length];
        int[] max = new int[nums.length];
        min[0] = max[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int value = nums[i];
            if (value > 0){
                min[i] = Math.min(min[i - 1] * value, value);
                max[i] = Math.max(max[i - 1] * value, value);
            }else {
                min[i] = Math.min(max[i - 1] * value, value);
                max[i] = Math.max(min[i - 1] * value, value);
            }
        }
        Arrays.sort(max);
        return max[nums.length - 1];
    }
}
