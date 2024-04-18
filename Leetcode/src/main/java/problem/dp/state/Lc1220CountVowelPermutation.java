package problem.dp.state;

import java.util.Arrays;

public class Lc1220CountVowelPermutation {

    public int countVowelPermutation(int n) {
        int[][] dp = new int[n + 1][5];
        int mod = (int) 1e9 + 7;
        Arrays.fill(dp[1], 1);
        for (int i = 2; i <= n; i++) {
            dp[i][0] = dp[i - 1][1];
            dp[i][1] = dp[i - 1][0] + dp[i - 1][2];
            dp[i][1] %= mod;
//            dp[i][2] = dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][3] + dp[i - 1][4];
            dp[i][2] = dp[i - 1][0] + dp[i - 1][1];
            dp[i][2] %= mod;
            dp[i][2] += dp[i - 1][3];
            dp[i][2] %= mod;
            dp[i][2] += dp[i - 1][4];
            dp[i][2] %= mod;
            dp[i][3] = dp[i - 1][2] + dp[i - 1][4];
            dp[i][3] %= mod;
            dp[i][4] = dp[i - 1][0];
        }
        int sum = dp[n][0] + dp[n][1];
        sum %= mod;
        sum += dp[n][2];
        sum %= mod;
        sum += dp[n][3];
        sum %= mod;
        sum += dp[n][4];
        sum %= mod;
        return sum;
    }
}
