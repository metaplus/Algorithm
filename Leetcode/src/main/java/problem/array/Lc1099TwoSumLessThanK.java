package problem.array;

import java.util.Arrays;

public class Lc1099TwoSumLessThanK {
    public int twoSumLessThanK(int[] nums, int k) {
        Arrays.sort(nums);
            int sumMax = -1;
        for (int left = 0, right = nums.length - 1; left < right; ) {
            if (nums[left] + nums[left + 1] >= k) {
                break;
            }
            int sum = nums[left] + nums[right];
            if (sum >= k) {
                right--;
                continue;
            }
            sumMax = Math.max(sum, sumMax);
            left++;
        }
        return sumMax;
    }
}
