package problem.dp;

import java.util.Arrays;

public class Lc322CoinChange {

    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin < 0) {
                    continue;
                }
                if (i - coin == 0 || dp[i - coin] > 0) {
                    dp[i] = dp[i] == 0 ? dp[i - coin] + 1 : Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] > 0 ? dp[amount] : -1;
    }


    public int coinChange3(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        int inf = Integer.MAX_VALUE / 2;
        Arrays.fill(dp, inf);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] < inf ? dp[amount] : -1;
    }

    public int coinChange2(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            int lenMin = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (i - coin >= 0 && dp[i - coin] >= 0) {
                    lenMin = Math.min(lenMin, dp[i - coin] + 1);
                }
            }
            dp[i] = lenMin < Integer.MAX_VALUE ? lenMin : Integer.MIN_VALUE;
        }
        return dp[amount] >= 0 ? dp[amount] : -1;
    }

    private int dfs(int[] coins, int id, int amount, int lenMin) {
        if (amount == 0) {
            return 0;
        }
        if (id >= coins.length) {
            return Integer.MAX_VALUE;
        }
        int div = amount / coins[id];
        if (amount % coins[id] == 0) {
            return div;
        }
        if (div >= lenMin) {
            return Integer.MAX_VALUE;
        }
        for (int i = div; i >= 0; i--) {
            int len = dfs(coins, id + 1, amount - i * coins[id], lenMin - i);
            if (len < Integer.MAX_VALUE) {
                lenMin = Math.min(i + len, lenMin);
            }
        }
        return lenMin;
    }

}
