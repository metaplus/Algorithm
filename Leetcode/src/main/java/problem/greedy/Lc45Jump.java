package problem.greedy;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Lc45Jump {

    // 74ms
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, Integer.MAX_VALUE / 2);
        dp[nums.length - 1] = 0;
        for (int i = nums.length - 2; i >= 0; i--) {
            for (int j = 1; j <= nums[i]; j++) {
                if (i + j >= nums.length) {
                    break;
                }
                dp[i] = Math.min(dp[i], 1 + dp[i + j]);
            }
        }
        return dp[0];
    }

    // 9ms
    public int jump3(int[] nums) {
        int[] dp = new int[nums.length];
        Deque<Integer> deque = new ArrayDeque<>();
        deque.offer(0);
        while (!deque.isEmpty()) {
            int size = deque.size();
            while (size-- > 0) {
                Integer pos = deque.poll();
                for (int i = nums[pos]; i > 0; i--) {
                    if (pos + i >= nums.length) {
                        continue;
                    }
                    if (dp[pos + i] > 0) {
                        break;
                    }
                    dp[pos + i] = dp[pos] + 1;
                    deque.offer(pos + i);
                }
//                for (int i = 1; i <= nums[pos]; i++) {
//                    if (pos + i >= nums.length) {
//                        break;
//                    }
//                    if (dp[pos + i] > 0) {
//                        continue;
//                    }
//                    dp[pos + i] = dp[pos] + 1;
//                    deque.offer(pos + i);
//                }
            }
        }
        return dp[nums.length - 1];
    }


    // 9ms
    public int jump2(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        int right = 0;
        for (int i = 1; right < nums.length; i++) {
            int max = right;
            for (int j = right; j >= 0; j--) {
                if (nums[j] + j > max) {
                    max = nums[j] + j;
                }
            }
            if (max >= nums.length - 1) {
                return i;
            }
            right = max;
        }
        return -1;
    }
}
