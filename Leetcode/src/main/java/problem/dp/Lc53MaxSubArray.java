package problem.dp;

public class Lc53MaxSubArray {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int sumMax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
            sumMax = Math.max(sumMax, dp[i]);
        }
        return sumMax;
    }

    public int maxSubArray2(int[] nums) {
        if (nums.length < 2) {
            return nums[0];
        }
        int sum = nums[0];
        int sumMax = sum;
        for (int i = 1; i < nums.length; i++) {
            if (sum < 0) {
                sum = nums[i];
                sumMax = Math.max(sum, sumMax);
                continue;
            }
            sum += nums[i];
            sumMax = Math.max(sum, sumMax);
        }
        return sumMax;
    }
}
