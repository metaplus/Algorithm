package problem.dp;

public class Lc152MaxProduct {

    public int maxProduct(int[] nums) {
        int max = nums[0];
        int[] dpMin = new int[nums.length];
        int[] dpMax = new int[nums.length];
        dpMin[0] = nums[0];
        dpMax[0] = nums[0];
        for (int i = 1; i < dpMin.length; i++) {
            if (nums[i] == 0) {
                dpMax[i] = dpMin[i] = 0;
                max = Math.max(max, dpMax[i]);
                continue;
            }
            if (nums[i] > 0) {
                dpMax[i] = Math.max(nums[i], nums[i] * dpMax[i - 1]);
                dpMin[i] = Math.min(nums[i], nums[i] * dpMin[i - 1]);
                max = Math.max(max, dpMax[i]);
                continue;
            }
            dpMax[i] = Math.max(nums[i], nums[i] * dpMin[i - 1]);
            dpMin[i] = Math.min(nums[i], nums[i] * dpMax[i - 1]);
            max = Math.max(max, dpMax[i]);
        }
        return max;
    }

}
