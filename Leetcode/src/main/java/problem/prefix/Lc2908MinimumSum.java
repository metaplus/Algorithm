package problem.prefix;

public class Lc2908MinimumSum {

    public int minimumSum(int[] nums) {
        int[] prefix = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i > 0) {
                prefix[i] = Math.min(prefix[i - 1], nums[i]);
                continue;
            }
            prefix[i] = nums[i];
        }
        int[] suffix = new int[nums.length];
        for (int j = nums.length - 1; j >= 0; j--) {
            if (j < nums.length - 1) {
                suffix[j] = Math.min(suffix[j + 1], nums[j]);
                continue;
            }
            suffix[j] = nums[j];
        }
        int sumMin = Integer.MAX_VALUE;
        for (int i = 1; i < nums.length - 1; i++) {
            if (prefix[i - 1] < nums[i]
                    && nums[i] > suffix[i + 1]) {
                int sum = prefix[i - 1] + nums[i] + suffix[i + 1];
                sumMin = Math.min(sum, sumMin);
            }
        }
        return sumMin < Integer.MAX_VALUE ? sumMin : -1;
    }
}
