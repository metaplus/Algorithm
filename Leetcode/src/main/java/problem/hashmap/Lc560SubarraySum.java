package problem.hashmap;

import java.util.HashMap;
import java.util.Map;

public class Lc560SubarraySum {

    public int subarraySum(int[] nums, int k) {

        int preSum = 0;
        Map<Integer, Integer> preCounts = new HashMap<>();
        preCounts.put(0, 1);
        int arr = 0;
        for (int i = 0; i < nums.length; i++) {
            preSum += nums[i];
            arr += preCounts.getOrDefault(preSum - k, 0);
            preCounts.merge(preSum, 1, Integer::sum);
        }
        return arr;
    }
}
