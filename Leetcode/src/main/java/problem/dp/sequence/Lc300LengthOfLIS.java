package problem.dp.sequence;

import problem.tree.Lc1483TreeAncestor;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class Lc300LengthOfLIS {

    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length + 1];
        int len = 0;
        dp[0] = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > dp[len]) {
                dp[++len] = nums[i];
                continue;
            }
            int left = 1;
            int right = len + 1;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (dp[mid] < nums[i]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            dp[left] = nums[i];
        }
        return len;
    }

    public int lengthOfLIS2(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int max = 1;
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    max = Math.max(dp[i], max);
                }
            }
        }
        return max;
    }
}
