package problem.dp.sequence;

public class Lc2708MaxStrength {

    public long maxStrength(int[] nums) {
        long[] dpMin = new long[nums.length];
        long[] dpMax = new long[nums.length];
        dpMin[0] = nums[0];
        dpMax[0] = nums[0];
        long min = nums[0];
        long max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            long val1 = max * nums[i];
            long val2 = min * nums[i];
            dpMax[i] = Math.max(max, nums[i]);
            dpMax[i] = Math.max(dpMax[i], val1);
            dpMax[i] = Math.max(dpMax[i], val2);
            dpMin[i] = Math.min(min, nums[i]);
            dpMin[i] = Math.min(dpMin[i], val1);
            dpMin[i] = Math.min(dpMin[i], val2);
            max = Math.max(max, dpMax[i]);
            min = Math.min(min, dpMin[i]);
        }
        return max;
    }
}
