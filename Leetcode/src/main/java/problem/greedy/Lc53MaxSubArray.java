package problem.greedy;

import java.util.Arrays;

public class Lc53MaxSubArray {

    public int maxSubArray(int[] nums) {
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
