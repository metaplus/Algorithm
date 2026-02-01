package problem.search.binary;

import java.util.Arrays;

public class Lc1877MinPairSum {

    public int minPairSum(int[] nums) {
        if (nums.length < 3) {
            return nums[0] + nums[1];
        }
        Arrays.sort(nums);
        int result = 0;
        for (int i = 0, j = nums.length - 1; i < j; i++, j--) {
            result = Math.max(result, nums[i] + nums[j]);
        }
        return result;
    }
}
