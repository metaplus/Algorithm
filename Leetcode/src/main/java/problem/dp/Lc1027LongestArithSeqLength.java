package problem.dp;

import java.util.HashMap;
import java.util.Map;

public class Lc1027LongestArithSeqLength {

    public int longestArithSeqLength(int[] nums) {
        int min = nums[0];
        int max = nums[0];
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        int lenMax = 1;
        for (int i = min - max; i <= max - min; i++) {
            int len = longSeq(nums, i);
            lenMax = Math.max(len, lenMax);
        }
        return lenMax;
    }

    public int longSeq(int[] nums, int diff) {
        Map<Integer, Integer> dp = new HashMap<>();
        dp.put(nums[0], 1);
        int lenMax = 1;
        for (int i = 1; i < nums.length; i++) {
            int len = dp.getOrDefault(nums[i] - diff, 0) + 1;
            dp.put(nums[i], len);
            lenMax = Math.max(len, lenMax);
        }
        return lenMax;
    }
}
