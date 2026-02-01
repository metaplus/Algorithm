package problem.sort;

import java.util.Arrays;

public class Lc1984MinimumDifference {

    public int minimumDifference(int[] nums, int k) {
        if (k == 1) {
            return 0;
        }
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE;
        for (int i = 0, last = nums.length - k + 1; i < last; i++) {
            diff = Math.min(diff, nums[i + k - 1] - nums[i]);
            if (diff == 0) {
                return 0;
            }
        }
        return diff;
    }
}
