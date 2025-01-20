package problem.search.binary;

import java.util.Arrays;

public class Lc1498NumSubseq {

    public int numSubseq(int[] nums, int target) {
        long sum = 0;
        int mod = 1000_000_007;
        int[] add = new int[nums.length];
        add[0] = 1;
        for (int i = 1; i < add.length; i++) {
            add[i] = add[i - 1] << 1;
            add[i] %= mod;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > target - nums[i]) {
                break;
            }
            int left = i + 1;
            int right = nums.length;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (nums[i] <= target - nums[mid]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            long incr = add[left - i - 1];
            sum += incr;
            sum %= mod;
        }
        return (int) sum;
    }
}
