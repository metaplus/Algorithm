package problem.dp.bag;

public class Lc474FindMaxForm {

    public int findMaxForm(String[] strs, int m, int n) {
        int[][][] dp = new int[strs.length + 1][m + 1][n + 1];
        for (int k = 1; k <= strs.length; k++) {
            int one = 0;
            int zero = 0;
            for (char c : strs[k - 1].toCharArray()) {
                if (c == '1') {
                    one++;
                    continue;
                }
                zero++;
            }
            for (int i = 0; i <= m; i++) {
                for (int j = 0; j <= n; j++) {
                    dp[k][i][j] = dp[k - 1][i][j];
                    if (i >= zero && j >= one) {
                        dp[k][i][j] = Math.max(dp[k][i][j], dp[k - 1][i - zero][j - one] + 1);
                    }
                }
            }
        }
        return dp[strs.length][m][n];
    }
}
