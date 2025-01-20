package problem.dp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Lc416CanPartition {

    public boolean canPartition(int[] nums) {
        int sum = 0;
        int max = 0;
        for (int num : nums) {
            sum += num;
            max = Math.max(max, num);
        }
        if (sum % 2 == 1) {
            return false;
        }
        int half = sum / 2;
        if (max > half) {
            return false;
        }
        if (max == half) {
            return true;
        }
        boolean[] dp = new boolean[half + 1];
        dp[0] = true;
        for (int num : nums) {
            boolean[] dp1 = Arrays.copyOf(dp, dp.length);
            for (int i = num; i <= half; i++) {
                if (!dp1[i]) {
                    dp1[i] = dp[i - num];
                }
            }
            dp = dp1;
        }
        return dp[half];
    }

    public boolean canPartition4(int[] nums) {
        int sum = 0;
        int max = 0;
        for (int num : nums) {
            sum += num;
            max = Math.max(max, num);
        }
        if (sum % 2 == 1) {
            return false;
        }
        int half = sum / 2;
        if (max > half) {
            return false;
        }
        if (max == half) {
            return true;
        }
        Set<Integer> dp = new HashSet<>();
        dp.add(0);
        for (int num : nums) {
            Set<Integer> add = new HashSet<>(dp.size());
            for (Integer i : dp) {
                if (i > half) {
                    continue;
                }
                int val = i + num;
                if (val > half) {
                    continue;
                }
                if (val == half) {
                    return true;
                }
                add.add(val);
            }
            dp.addAll(add);
        }
        return dp.contains(half);
    }

    public boolean canPartition3(int[] nums) {
        if (nums.length < 2) {
            return false;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1) {
            return false;
        }
        int mean = sum / 2;
        boolean[][] dp = new boolean[nums.length][mean + 1];
        dp[0][0] = true;
        if (nums[0] <= mean) {
            dp[0][nums[0]] = true;
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j <= mean; j++) {
                dp[i][j] |= dp[i - 1][j];
                dp[i][j] |= j - nums[i] >= 0 && dp[i - 1][j - nums[i]];

            }
        }
        return dp[nums.length - 1][mean];
    }

    public boolean canPartition2(int[] nums) {
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
