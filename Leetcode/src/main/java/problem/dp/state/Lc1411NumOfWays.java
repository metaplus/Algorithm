package problem.dp.state;

public class Lc1411NumOfWays {

    private static long MOD = 1000_000_000 + 7;


    //todo: fail
    public int numOfWays(int n) {
        long[][][] dp = new long[n][3][3];
        for (int i = 0; i < n; i++) {
            dp[i][0][0] = (i > 0 ? dp[i - 1][0][1] + dp[i - 1][0][2] : 1);
            dp[i][0][1] = (i > 0 ? dp[i - 1][0][0] + dp[i - 1][0][2] : 1);
            dp[i][0][2] = (i > 0 ? dp[i - 1][0][0] + dp[i - 1][0][1] : 1);
            for (int j = 1; j < 3; j++) {
                dp[i][j][0] = (dp[i][j - 1][1] + dp[i][j - 1][2]) * (i > 0 ? dp[i - 1][j][1] + dp[i - 1][j][2] : 1);
                dp[i][j][1] = (dp[i][j - 1][0] + dp[i][j - 1][2]) * (i > 0 ? dp[i - 1][j][0] + dp[i - 1][j][2] : 1);
                dp[i][j][2] = (dp[i][j - 1][0] + dp[i][j - 1][1]) * (i > 0 ? dp[i - 1][j][0] + dp[i - 1][j][1] : 1);
            }
        }
        long sum = dp[n - 1][2][0] + dp[n - 1][2][1] + dp[n - 1][2][2];
        return (int) (sum % MOD);
    }
}
