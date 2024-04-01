package problem.dp;

public class Lc486PredictTheWinner {
    public boolean predictTheWinner(int[] nums) {
        int[][] dp = new int[nums.length][nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i][i] = nums[i];
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            for (int j = i + 1; j < nums.length; j++) {
                dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
            }
        }
        return dp[0][nums.length - 1] >= 0;
    }

    // fail
    public boolean predictTheWinner2(int[] nums) {
        int sum1 = 0;
        int sum2 = 0;
        for (int left = 0, right = nums.length - 1; left <= right; ) {
            if (left == right) {
                sum1 += nums[left];
                break;
            }
            if (Math.max(nums[left + 1], nums[right]) < Math.max(nums[left], nums[right - 1])) {
                sum1 += nums[left++];
            } else {
                sum1 += nums[right--];
            }
            if (left == right) {
                sum2 += nums[left];
                break;
            }
            if (Math.max(nums[left + 1], nums[right]) < Math.max(nums[left], nums[right - 1])) {
                sum2 += nums[left++];
            } else {
                sum2 += nums[right--];
            }
        }
        return sum1 >= sum2;
    }
}
