package com.code;

public class Q122 {

    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) return 0;
        //dp[i][j] 第i天是否持股的受益；
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][0] - prices[i], dp[i - 1][1]);
        }
        return dp[prices.length - 1][0];
    }
}