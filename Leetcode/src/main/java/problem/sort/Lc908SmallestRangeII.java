package problem.sort;

import java.util.Arrays;

public class Lc908SmallestRangeII {

    public int smallestRangeII(int[] nums, int k) {
        if (nums.length < 2) {
            return 0;
        }
        countSort(nums);
        int gap = nums[nums.length - 1] - nums[0];
        for (int i = 1; i < nums.length; i++) {
            int max = Math.max(nums[nums.length - 1] - k, nums[i - 1] + k);
            int min = Math.min(nums[0] + k, nums[i] - k);
            gap = Math.min(gap, max - min);
        }
        return gap;
    }

    private static void countSort(int[] nums) {
        int min = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }
        int[] count = new int[max - min + 1];
        for (int num : nums) {
            count[num - min]++;
        }
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }
        int[] sort = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            sort[--count[nums[i] - min]] = nums[i];
        }
        System.arraycopy(sort, 0, nums, 0, nums.length);
    }
}
