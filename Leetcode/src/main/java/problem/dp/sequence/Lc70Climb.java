package problem.dp.sequence;

public class Lc70Climb {

    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1] + (i - 2 >= 0 ? dp[i - 2] : 0);
        }
        return dp[n];
    }
}
