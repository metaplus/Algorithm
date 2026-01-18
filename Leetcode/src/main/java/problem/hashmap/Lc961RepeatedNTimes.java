package problem.hashmap;

import java.util.HashMap;
import java.util.Map;

public class Lc961RepeatedNTimes {

    public int repeatedNTimes(int[] nums) {
        int limit = nums.length / 2;
        Map<Integer, Integer> counts = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int count = counts.getOrDefault(nums[i], 0);
            if (count + 1 == limit) {
                return nums[i];
            }
            int sum = count + 1 + nums.length - i;
            if (sum < limit) {
                continue;
            }
            counts.merge(nums[i], 1, Integer::sum);
        }
        return -1;
    }
}
