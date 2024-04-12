package problem.dp.bag;

import java.util.Arrays;

public class Lc518Change {

    // time long
    public int change(int amount, int[] coins) {
        int[][] dp = new int[amount + 1][coins.length];
        Arrays.fill(dp[0], 1);
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0) {
                    dp[i][j] = dp[i - coins[j]][j];
                }
                for (int k = 0; k < j; k++) {
                    if (i - coins[k] >= 0) {
                        dp[i][j] += dp[i - coins[k]][k];
                    }
                }
            }
        }
        return dp[amount][coins.length - 1];
    }

    public int change2(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }
}
