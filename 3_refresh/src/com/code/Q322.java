package com.code;

import java.util.Arrays;

//给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回
// -1。
//
// 你可以认为每种硬币的数量是无限的。
//
//
//
// 示例 1：
//
//
//输入：coins = [1, 2, 5], amount = 11
//输出：3
//解释：11 = 5 + 5 + 1
public class Q322 {
    public int coinChange(int[] coins, int amount) {
        int maxCount = amount;
        int dp[] = new int[amount];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i < amount; i++) {
            for (int coin : coins) {
                dp[i] = Math.min(dp[i], dp[i - coin]) + 1;
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];

    }
}
