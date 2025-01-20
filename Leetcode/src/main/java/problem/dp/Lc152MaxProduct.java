package problem.dp;

public class Lc152MaxProduct {

    public int maxProduct(int[] nums) {
        int[][] dpMax = new int[nums.length][2];
        int[][] dpMin = new int[nums.length][2];
        dpMax[0][1] = nums[0];
        dpMin[0][1] = nums[0];
        dpMax[0][0] = Integer.MIN_VALUE;
        dpMin[0][0] = Integer.MAX_VALUE;
        for (int i = 1; i < nums.length; i++) {
            dpMax[i][0] = Math.max(dpMax[i - 1][0], dpMax[i - 1][1]);
            dpMax[i][1] = Math.max(nums[i], dpMax[i - 1][1] * nums[i]);
            dpMax[i][1] = Math.max(dpMax[i][1], dpMin[i - 1][1] * nums[i]);
            dpMin[i][0] = Math.min(dpMin[i - 1][0], dpMin[i - 1][1]);
            dpMin[i][1] = Math.min(nums[i], dpMax[i - 1][1] * nums[i]);
            dpMin[i][1] = Math.min(dpMin[i][1], dpMin[i - 1][1] * nums[i]);
        }
        return Math.max(dpMax[nums.length - 1][1], dpMax[nums.length - 1][0]);
    }

    public int maxProduct2(int[] nums) {
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
