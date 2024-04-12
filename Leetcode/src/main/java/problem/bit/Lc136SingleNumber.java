package problem.bit;

import java.util.Arrays;

public class Lc136SingleNumber {

    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
             result ^= num;
        }
        return result;
    }

    public int singleNumber2(int[] nums) {
        if (nums.length < 2) {
            return nums[0];
        }
        int max = Math.abs(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max, Math.abs(nums[i]));
        }
        int digit = 1;
        for (int i = max; i > 0; i /= 10, digit++) {
        }
        int[] count = new int[19];
        int[] sort = new int[nums.length];
        int div = 1;
        Arrays.fill(sort, Integer.MIN_VALUE);
        for (int i = 0; i < digit; i++, div *= 10) {
            for (int num : nums) {
                count[(num / div) % 10 + 9]++;
            }
            for (int j = 1; j < count.length; j++) {
                count[j] += count[j - 1];
            }
            for (int j = nums.length - 1; j >= 0; j--) {
                int index = --count[(nums[j] / div) % 10 + 9];
                sort[index] = nums[j];

            }
            Arrays.fill(count, 0);
            System.arraycopy(sort, 0, nums, 0, nums.length);
            Arrays.fill(sort, Integer.MIN_VALUE);
        }
        if (nums[0] != nums[1]) {
            return nums[0];
        }
        if (nums[nums.length - 2] != nums[nums.length - 1]) {
            return nums[nums.length - 1];
        }
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i - 1] != nums[i]
                    && nums[i + 1] != nums[i]) {
                return nums[i];
            }
        }
        return -1;
    }
}
