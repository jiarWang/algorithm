package com.code;

//给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
//
// 示例 1:
//
// 输入: 2
//输出: [0,1,1]
//
public class Q338 {
    public int[] countBits(int num) {
        int[] dp = new int[num];
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            if ((i & 1) == 1) {
                //奇数
                dp[i] = dp[i - 1] + 1;
            } else {
                //偶数
                dp[i] = dp[i / 2];
            }
        }
        return dp;
    }
}
