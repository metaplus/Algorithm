package problem.dp.state;

public class Lc309MaxProfit {


    public int maxProfit(int[] prices) {
        int buy = 0;
        int sold = 1;
        int freeze = 2;
        int[] dp = new int[3];
        dp[buy] = -prices[0];
        dp[sold] = 0;
        dp[freeze] = 0;
        for (int i = 1; i < prices.length; i++) {
            int[] dp1 = new int[3];
            dp1[buy] = Math.max(dp[buy],dp[freeze] - prices[i]);
            dp1[sold] = dp[buy] + prices[i];
            dp1[freeze] = Math.max(dp[freeze],dp[sold]);
            dp = dp1;
        }
        return Math.max(dp[buy], Math.max(dp[sold], dp[freeze]));
    }

    public int maxProfit2(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        int inf = Integer.MIN_VALUE / 2;
        int[][] dp = new int[prices.length][3];
        dp[0][0] = -prices[0];
        dp[0][1] = inf;
        dp[0][2] = 0;
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2] - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1]);
        }
        return Math.max(dp[prices.length - 1][1], dp[prices.length - 1][2]);
    }
}
