package problem.dp;

public class Lc53MaxSubArray {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int preMin = 0;
        int sumMax = nums[0];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            sumMax = Math.max(sumMax, sum - preMin);
            preMin = Math.min(preMin, sum);
        }
        return sumMax;
    }

    public int maxSubArray4(int[] nums) {
        int[] pre = new int[nums.length];
        pre[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            pre[i] = pre[i - 1] + nums[i];
        }
        int[] preMin = new int[nums.length];
        preMin[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            preMin[i] = Math.min(preMin[i - 1], pre[i]);
        }
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result = Math.max(result, pre[i]);
            result = Math.max(result, pre[i] - preMin[i - 1]);
        }
        return result;
    }

    public int maxSubArray3(int[] nums) {
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
