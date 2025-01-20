package problem.dp.bag;

import java.util.HashMap;
import java.util.Map;

public class Lc494FindTargetSumWays {

    public int findTargetSumWays(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int num : nums) {
            Map<Integer, Integer> next = new HashMap<>(map.size());
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                next.merge(entry.getKey() + num, entry.getValue(), Integer::sum);
                next.merge(entry.getKey() - num, entry.getValue(), Integer::sum);
            }
            map = next;
        }
        return map.getOrDefault(target, 0);
    }

    public int findTargetSumWays2(int[] nums, int target) {
        int[][] dp = new int[nums.length][2001];
        dp[0][nums[0] + 1000] = 1;
        dp[0][-nums[0] + 1000]++;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j <= 2000; j++) {
                if (j - nums[i] >= 0) {
                    dp[i][j] += dp[i - 1][j - nums[i]];
                }
                if (j + nums[i] <= 2000) {
                    dp[i][j] += dp[i - 1][j + nums[i]];
                }
            }
        }
        return dp[nums.length - 1][target + 1000];
    }
}
