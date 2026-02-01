package problem.array.prefix;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Lc3020MaximumLength {


    // fai
    public int maximumLength(int[] nums) {
        Arrays.sort(nums);
        int result = 1;
        Map<Long, Integer> ranges = new TreeMap<>();
        for (int i = 0; i < nums.length; ) {
            if (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                long next = ((long) nums[i]) * nums[i];
                Integer len = ranges.get((long) nums[i]);
                if (len != null) {
                    ranges.remove((long) nums[i]);
                    ranges.put(next, len + 2);
                    result = Math.max(result, len + 2);
                } else {
                    ranges.put(next, 2);
                    result = Math.max(result, 2);
                }
                i += 2;
                continue;
            }
            Integer len = ranges.get((long) nums[i]);
            if (len != null) {
                result = Math.max(result, len + 1);
            }
            i++;
        }
        return result % 2 == 0 ? result - 1 : result;
    }

}
