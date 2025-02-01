package problem.dp;

public class Lc121MaxProfit {

    public int maxProfit(int[] prices) {
        int[] dp = new int[prices.length];
        dp[0] = prices[0];
        int result = 0;
        for (int i = 1; i < prices.length; i++) {
            result = Math.max(result, prices[i] - dp[i - 1]);
            dp[i] = Math.min(prices[i], dp[i - 1]);
        }
        return result;
    }

    public int maxProfit2(int[] prices) {
        int[] dp = new int[prices.length];
        dp[dp.length - 1] = prices[prices.length - 1];
        for (int i = dp.length - 2; i >= 0; i--) {
            dp[i] = Math.max(prices[i], dp[i + 1]);
        }
        int max = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            max = Math.max(max, dp[i + 1] - prices[i]);
        }
        return max;
    }
}
