package problem.dp;

public class Lc918MaxSubarraySumCircular {

    public int maxSubarraySumCircular(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        int[][] dp = new int[nums.length][2];
        dp[0][0] = nums[0];
        dp[0][1] = nums[0];
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum += nums[i];
            dp[i][0] = Math.max(dp[i - 1][0] + nums[i], nums[i]);
            dp[i][1] = Math.min(dp[i - 1][1] + nums[i], nums[i]);
            max = Math.max(max, dp[i][0]);
            min = Math.min(min, dp[i][1]);
        }
        if (sum == min) {
            return max;
        }
        return Math.max(max, sum - min);
    }
}
