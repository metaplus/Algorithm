package problem.dp;

public class Lc712MinimumDeleteSum {

    public int minimumDeleteSum(String s1, String s2) {
        char[] array1 = s1.toCharArray();
        char[] array2 = s2.toCharArray();
        int[][] dp = new int[array1.length + 1][array2.length + 1];
        for (int j = 1; j < array2.length + 1; j++) {
            dp[0][j] = dp[0][j - 1] + array2[j - 1];
        }
        for (int i = 1; i < array1.length + 1; i++) {
            dp[i][0] = dp[i - 1][0] + array1[i - 1];
            for (int j = 1; j < array2.length + 1; j++) {
                if (array1[i - 1] == array2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                    continue;
                }
                dp[i][j] = Math.min(dp[i][j - 1] + array2[j - 1], dp[i - 1][j] + array1[i - 1]);
            }
        }
        return dp[array1.length][array2.length];
    }

    public int minimumDeleteSum2(String s1, String s2) {
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
