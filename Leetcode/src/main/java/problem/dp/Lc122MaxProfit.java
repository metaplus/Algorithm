package problem.dp;

public class Lc122MaxProfit {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        dp[0][1] = -prices[0];
        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[prices.length - 1][0];
    }

    public int maxProfit2(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        int buy = 0;
        boolean in = false;
        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (in) {
                if (i + 1 == prices.length || prices[i] > prices[i + 1]) {
                    profit += (prices[i] - buy);
                    buy = 0;
                    in = false;
                }
                continue;
            }
            if (i + 1 < prices.length && prices[i] < prices[i + 1]) {
                buy = prices[i];
                in = true;
            }
        }
        return profit;
    }
}
