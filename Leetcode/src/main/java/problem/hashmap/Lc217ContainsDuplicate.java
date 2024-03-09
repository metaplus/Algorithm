package problem.hashmap;

import java.util.Arrays;

public class Lc217ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {
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
                if (index < nums.length - 1
                        && sort[index] == sort[index + 1]) {
                    return true;
                }
            }
            Arrays.fill(count, 0);
            System.arraycopy(sort, 0, nums, 0, nums.length);
            Arrays.fill(sort, Integer.MIN_VALUE);
        }
        return false;
    }
}
