package com.code;

//121. 买卖股票的最佳时机
public class Q121 {

    public static void main(String[] args) {
        int[] x = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(x));
    }
    public static int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        //0不持有 1持有
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            //不持有
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            //持有
            dp[i][1] = Math.max(-prices[i], dp[i - 1][1]);
        }
        return dp[prices.length - 1][0];
    }
}
