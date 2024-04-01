package problem.dp;

public class Lc416CanPartition {

    public boolean canPartition(int[] nums) {
        if (nums.length < 2) {
            return false;
        }
        int sum = 0;
        int valMax = 0;
        for (int val : nums) {
            sum += val;
            valMax = Math.max(val, valMax);
        }
        if ((sum & 1) == 1) {
            return false;
        }
        int mean = sum / 2;
        if (valMax > mean) {
            return false;
        }
        if (valMax == mean) {
            return true;
        }
        boolean[][] dp = new boolean[nums.length][mean + 1];
        if (nums[0] == mean) {
            return true;
        }
        dp[0][nums[0]] = true;
        dp[0][0] = true;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j <= mean; j++) {
                dp[i][j] = dp[i - 1][j];
                if (!dp[i][j] && j - nums[i] >= 0) {
                    dp[i][j] |= dp[i - 1][j - nums[i]];
                }
            }
        }
        return dp[nums.length - 1][mean];
    }
}
