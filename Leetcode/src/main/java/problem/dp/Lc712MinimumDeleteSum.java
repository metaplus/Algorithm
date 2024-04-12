package problem.dp;

public class Lc712MinimumDeleteSum {

    public int minimumDeleteSum(String s1, String s2) {
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0) {
                    if (j > 0) {
                        dp[i][j] = dp[i][j - 1] + arr2[j - 1];
                    }
                    continue;
                }
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + arr1[i - 1];
                    continue;
                }
                dp[i][j] = Math.min(dp[i - 1][j] + arr1[i - 1], dp[i][j - 1] + arr2[j - 1]);
                if (arr1[i - 1] == arr2[j - 1]) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1]);
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }
}
