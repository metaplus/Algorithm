package problem.dp;

public class Lc123MaxProfit {

    public int maxProfit(int[] prices) {
        int[][][] dp = new int[prices.length][2][3];
        dp[0][0][0] = 0;
        dp[0][1][1] = -prices[0];
        dp[0][1][2] = Integer.MIN_VALUE / 2;
        for (int i = 1; i < prices.length; i++) {
            for (int j = 1; j < 3; j++) {
                dp[i][0][j] = Math.max(dp[i - 1][0][j], dp[i - 1][1][j] + prices[i]);
                dp[i][1][j] = Math.max(dp[i - 1][1][j], dp[i - 1][0][j - 1] - prices[i]);
            }

        }
        return Math.max(dp[prices.length - 1][0][1], dp[prices.length - 1][0][2]);
    }
}
