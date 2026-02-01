package problem.dp.state;

public class Lc1653MinimumDeletions {

    public int minimumDeletions(String s) {
        if (s.length() < 2) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int[][] dp = new int[chars.length][2];
        dp[0][0] = chars[0] == 'a' ? 1 : 0;
        dp[0][1] = chars[0] == 'a' ? 0 : 1;
        for (int i = 1; i < chars.length; i++) {
            boolean isA = chars[i] == 'a';
            dp[i][0] = isA ? dp[i - 1][0] + 1 : dp[i - 1][0];
            dp[i][1] = !isA ? Math.max(dp[i - 1][1] + 1, dp[i - 1][0] + 1) : dp[i - 1][1];
        }
        return chars.length - Math.max(dp[chars.length - 1][0], dp[chars.length - 1][1]);
    }

}
