package problem.sort;

import java.util.Arrays;

public class Lc164MaximumGap {

    public int maximumGap(int[] nums) {
        radixSort(nums);
        int gap = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] > gap) {
                gap = nums[i] - nums[i - 1];
            }
        }
        return gap;
    }

    private void radixSort(int[] nums) {
        if (nums.length < 2) {
            return;
        }
        int max = 0;
        for (int num : nums) {
            if (num > max) {
                max = num;
            }
        }
        int digit = divideDigit(max);
        int[] count = new int[10];
        int[] sort = new int[nums.length];
        int div = 1;
        for (int i = 0; i < digit; i++) {
            for (int num : nums) {
                count[(num / div) % 10]++;
            }
            int pre = 0;
            for (int j = 0; j < count.length; j++) {
                int add = count[j];
                count[j] = pre;
                pre += add;
            }
            for (int num : nums) {
                sort[count[(num / div) % 10]++] = num;
            }
            div *= 10;
            Arrays.fill(count, 0);
            System.arraycopy(sort, 0, nums, 0, nums.length);
        }
    }

    private static int divideDigit(int max) {
        int digit = 1;
        while (max >= 10) {
            digit++;
            max /= 10;
        }
        return digit;
    }
}
