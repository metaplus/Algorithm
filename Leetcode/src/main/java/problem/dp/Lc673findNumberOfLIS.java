package problem.dp;

public class Lc673findNumberOfLIS {

    public int findNumberOfLIS(int[] nums) {
        int[][] dp = new int[nums.length][2];
        dp[0][0] = 1;
        dp[0][1] = 1;
        int lenMax = 1;
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i][0] = 1;
            dp[i][1] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (dp[j][0] + 1 > dp[i][0]) {
                        dp[i][0] = dp[j][0] + 1;
                        dp[i][1] = dp[j][1];
                    } else if (dp[j][0] + 1 == dp[i][0]) {
                        dp[i][1] += dp[j][1];
                    }
                    dp[i][0] = Math.max(dp[i][0], dp[j][0] + 1);
                }
            }
            if (dp[i][0] > lenMax) {
                lenMax = dp[i][0];
                count = dp[i][1];
            } else if (dp[i][0] == lenMax) {
                count += dp[i][1];
            }
        }
        return count;
    }
}
