package problem.array;

import java.util.Arrays;

public class Lc360SortTransformedArray {

    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = a * nums[i] * nums[i] + b * nums[i] + c;
        }
        radixSort(nums);
        return nums;
    }

    private void radixSort(int[] nums) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(Math.abs(num), max);
        }
        int digit = 0;
        for (int val = max; val > 0; val /= 10) {
            digit++;
        }
        int[] counts = new int[19];
        int[] sort = new int[nums.length];
        int div = 1;
        for (int i = 0; i < digit; i++) {
            for (int num : nums) {
                counts[(num / div % 10) + 9]++;
            }
            for (int j = 1; j < counts.length; j++) {
                counts[j] += counts[j - 1];
            }
            for (int j = nums.length - 1; j >= 0; j--) {
                sort[--counts[(nums[j] / div % 10) + 9]] = nums[j];
            }
            System.arraycopy(sort, 0, nums, 0, nums.length);
            Arrays.fill(counts, 0);
            div *= 10;
        }
    }
}
