package problem.dp;

import java.util.Arrays;

public class Lc188MaxProfit {

    public int maxProfit(int k, int[] prices) {
        int[][][] dp = new int[prices.length][2][k + 1];
        Arrays.fill(dp[0][1], Integer.MIN_VALUE / 2);
        dp[0][0][0] = 0;
        dp[0][1][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            for (int j = 1; j <= k; j++) {
                dp[i][0][j] = Math.max(dp[i - 1][0][j], dp[i - 1][1][j] + prices[i]);
                dp[i][1][j] = Math.max(dp[i - 1][1][j], dp[i - 1][0][j - 1] - prices[i]);
            }
        }
        int profitMax = 0;
        for (int i = 1; i <= k; i++) {
            profitMax = Math.max(profitMax, dp[prices.length - 1][0][i]);
        }
        return profitMax;
    }
}
