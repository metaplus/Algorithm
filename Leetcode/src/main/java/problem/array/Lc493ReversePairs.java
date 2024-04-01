package problem.array;

import java.util.Map;
import java.util.TreeMap;

public class Lc493ReversePairs {

    public int reversePairs(int[] nums) {
        TreeMap<Long, Integer> count = new TreeMap<>();
        int sum = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + 1 > nums.length - 1) {
                count.merge((long) nums[i], 1, Integer::sum);
                continue;
            }
            long val = ((long) nums[i] - 1) / 2;
            for (Map.Entry<Long, Integer> entry : count.headMap(val, true).entrySet()) {
                sum += entry.getValue();
            }
            count.merge((long) nums[i], 1, Integer::sum);
        }
        return sum;
    }
}
