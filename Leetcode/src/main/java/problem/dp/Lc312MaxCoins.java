package problem.dp;

public class Lc312MaxCoins {
    public int maxCoins(int[] nums) {
        if (nums.length < 2) {
            return nums[0];
        }
        int[][] dp = new int[nums.length][nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            for (int j = i; j < nums.length; j++) {
                for (int k = i; k <= j; k++) {
                    int sum = nums[k] * (i - 1 < 0 ? 1 : nums[i - 1]) * (j + 1 >= nums.length ? 1 : nums[j + 1]);
//                    sum += k - 1 < 0 ? 0 : dp[i][k - 1];
//                    sum += k + 1 >= nums.length ? 0 : dp[k + 1][j];
                    sum += k - 1 < i ? 0 : dp[i][k - 1];
                    sum += k + 1 > j ? 0 : dp[k + 1][j];
                    dp[i][j] = Math.max(dp[i][j], sum);
                }
            }
        }
        return dp[0][nums.length - 1];
    }

    public int maxCoins2(int[] nums) {
        int n = nums.length;
        int[][] rec = new int[n + 2][n + 2];
        int[] val = new int[n + 2];
        val[0] = val[n + 1] = 1;
        System.arraycopy(nums, 0, val, 1, n);
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 2; j <= n + 1; j++) {
                for (int k = i + 1; k < j; k++) {
                    int pre = val[i] * val[k] * val[j];
                    int sum = pre;
                    sum += rec[i][k] + rec[k][j];
                    rec[i][j] = Math.max(rec[i][j], sum);
                }
            }
        }
        return rec[0][n + 1];
    }

}
