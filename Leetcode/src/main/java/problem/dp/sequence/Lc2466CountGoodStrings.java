package problem.dp.sequence;

public class Lc2466CountGoodStrings {

    public int countGoodStrings(int low, int high, int zero, int one) {
        int[] dp = new int[high + 1];
        dp[0] = 1;
        int sum = 0;
        int mod = (int) (1e9 + 7);
        for (int i = 1; i <= high; i++) {
            if (i - zero >= 0) {
                dp[i] += dp[i - zero];
                dp[i] %= mod;
            }
            if (i - one >= 0) {
                dp[i] += dp[i - one];
                dp[i] %= mod;
            }
            if (i >= low) {
                sum += dp[i];
                sum %= mod;
            }
        }
        return sum;
    }
}
