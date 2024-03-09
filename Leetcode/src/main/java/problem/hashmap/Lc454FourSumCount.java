package problem.hashmap;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Lc454FourSumCount {

    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> sum1 = new HashMap<>();
        Map<Integer, Integer> sum2 = new HashMap<>();
        for (int i : nums1) {
            for (int j : nums2) {
                sum1.put(i + j, sum1.getOrDefault(i + j, 0) + 1);
            }
        }
        for (int i : nums3) {
            for (int j : nums4) {
                sum2.put(i + j, sum2.getOrDefault(i + j, 0) + 1);
            }
        }
        int count = 0;
        for (Map.Entry<Integer, Integer> entry : sum1.entrySet()) {
            Integer peer = sum2.get(-entry.getKey());
            if (Objects.isNull(peer)) {
                continue;
            }
            count += peer * entry.getValue();
        }
        return count;
    }
}
