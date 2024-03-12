package problem.array;

import java.util.Objects;
import java.util.TreeMap;

public class Lc1438LongestSubarray {

    public int longestSubarray(int[] nums, int limit) {
        TreeMap<Integer, Integer> counts = new TreeMap<>();
        int left = 0;
        int lenMax = 0;
        for (int i = 0; i < nums.length; i++) {
            counts.compute(nums[i], (k, v) -> Objects.isNull(v) ? 1 : v + 1);
            for (int j = left; j <= i && counts.lastKey() - counts.firstKey() > limit; j++) {
                counts.compute(nums[j], (k, v) -> v == 1 ? null : v - 1);
                left = j + 1;
            }
            int len = i - left + 1;
            lenMax = Math.max(len, lenMax);
        }
        return lenMax;
    }
}
