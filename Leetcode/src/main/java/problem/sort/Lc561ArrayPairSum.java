package problem.sort;

import java.util.Arrays;

public class Lc561ArrayPairSum {

    public int arrayPairSum(int[] nums) {
        radixSort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length - 1; i += 2) {
            sum += Math.min(nums[i], nums[i + 1]);
        }
        return sum;
    }

    private void radixSort(int[] nums) {
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (Math.abs(nums[i]) > Math.abs(max)) {
                max = nums[i];
            }
        }
        int digit = findDigit(max);
        int[] count = new int[19];
        int[] sort = new int[nums.length];
        int div = 1;
        for (int i = 0; i < digit; i++) {
            for (int num : nums) {
                count[(num / div) % 10 + 9]++;
            }
            for (int j = 1; j < count.length; j++) {
                count[j] += count[j - 1];
            }
            for (int j = nums.length - 1; j >= 0; j--) {
                sort[--count[(nums[j] / div) % 10 + 9]] = nums[j];
            }
            div *= 10;
            Arrays.fill(count, 0);
            System.arraycopy(sort, 0, nums, 0, nums.length);
        }
    }

    private int findDigit(int val) {
        int digit = 1;
        while (Math.abs(val) >= 10) {
            digit++;
            val /= 10;
        }
        return digit;
    }
}
