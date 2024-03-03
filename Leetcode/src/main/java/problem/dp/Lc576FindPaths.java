package problem.dp;

public class Lc576FindPaths {

    private final long MOD = 1000_000_007;

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int[][][] dp = new int[maxMove + 1][m][n];
        for (int i = 1; i <= maxMove; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < n; k++) {
                    if (i == 0) {
                        dp[i][j][k] = 0;
                        continue;
                    }
                    long path = 0;
                    if (j > 0) {
                        path += dp[i - 1][j - 1][k];
                    } else {
                        path += 1;
                    }
                    if (j < m - 1) {
                        path += dp[i - 1][j + 1][k];
                    } else {
                        path += 1;
                    }
                    if (k > 0) {
                        path += dp[i - 1][j][k - 1];
                    } else {
                        path += 1;
                    }
                    if (k < n - 1) {
                        path += dp[i - 1][j][k + 1];
                    } else {
                        path += 1;
                    }
                    dp[i][j][k] = Math.toIntExact(path % MOD);
                }
            }
        }
        return dp[maxMove][startRow][startColumn];
    }
}
