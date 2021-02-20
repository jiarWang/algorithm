package com.code;

import com.sun.deploy.util.ArrayUtil;

import java.util.Arrays;

//给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
//
// 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序
//列。
//
//
// 示例 1：
//
//
//输入：nums = [10,9,2,5,3,7,101,18]
//输出：4
//解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
//
//
// 示例 2：
//
//
//输入：nums = [0,1,0,3,2,3]
//输出：4
public class Q300 {
    public static void main(String[] args) {
        System.out.println(lengthOfLIS(new int[]{0,1,0,3,2,3}));
    }

    public static int lengthOfLIS(int[] nums) {
        int[] len = new int[nums.length];
        Arrays.fill(len, 1);
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]){
                   //0--j中 len[j] + 1 的值最大的那个
                    len[i] = Math.max(len[i], len[j] + 1);
                }
            }
            max = Math.max(max, len[i]);
            System.out.println(Arrays.toString(len));
        }
        return max;
    }
}
