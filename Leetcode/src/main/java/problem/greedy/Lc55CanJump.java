package problem.greedy;

public class Lc55CanJump {


    // timeout
    public boolean canJump(int[] nums) {
        boolean[][] dp = new boolean[nums.length][nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i][i] = true;
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            for (int j = i + 1; j < nums.length; j++) {
                dp[i][j] = false;
                for (int k = 1; k <= nums[i]; k++) {
                    if (dp[i + k][j]) {
                        dp[i][j] = true;
                        break;
                    }
                }
            }
        }
        return dp[0][nums.length - 1];
    }

    public boolean canJump2(int[] nums) {
        if (nums.length < 2) {
            return true;
        }
        if (nums[0] == 0) {
            return false;
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] += i;
        }
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == i && i < nums.length - 1) {
                continue;
            }
            if (max < i) {
                return false;
            }
            if (i == nums.length - 1 || nums[i] >= nums.length - 1) {
                return true;
            }
            max = Math.max(max, nums[i]);
        }
        return false;
    }
}
