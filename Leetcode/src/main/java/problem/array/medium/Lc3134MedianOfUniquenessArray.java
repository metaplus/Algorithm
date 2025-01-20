package problem.array.medium;

import java.util.HashSet;
import java.util.Set;

public class Lc3134MedianOfUniquenessArray {

    // fa
    private static int countDistinct(int[] nums, int len, int right) {
        int pos = 0;
        int win = 1;
        while (len > 0) {
            if (pos + len <= right) {
                pos += len;
            } else {
                Set<Integer> set = new HashSet<>(len);
                int start = right - pos;
                for (int i = start; i < start + win; i++) {
                    set.add(nums[i]);
                }
                return set.size();
            }
            len--;
            win++;
        }
        return 0;
    }

    public int medianOfUniquenessArray(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }
        int sum = (1 + nums.length) * nums.length / 2;
        if (sum % 2 == 1) {
            return countDistinct(nums, nums.length, sum / 2);
        }
        int right = countDistinct(nums, nums.length, sum / 2);
        int left = countDistinct(nums, nums.length, sum / 2 - 1);
        return Math.min(left, right);
    }
}
