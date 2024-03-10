package problem.array;

import java.util.Arrays;

public class Lc16ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        int sumResult = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1, k = nums.length - 1; j < k; ) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    j++;
                    continue;
                }
                int sum = nums[i] + nums[j] + nums[k];
                int dist = Math.abs(target - sum);
                if (dist < min) {
                    min = dist;
                    sumResult = sum;
                }
                if (sum - target > 0) {
                    k--;
                    continue;
                }
                if (sum - target < 0) {
                    j++;
                    continue;
                }
                break;
            }
        }
        return sumResult;
    }
}
