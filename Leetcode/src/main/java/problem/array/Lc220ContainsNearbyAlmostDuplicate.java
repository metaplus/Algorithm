package problem.array;

import java.util.NavigableMap;
import java.util.Objects;
import java.util.TreeMap;

public class Lc220ContainsNearbyAlmostDuplicate {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (i < 1) {
                map.compute(nums[i], (k, v) -> Objects.isNull(v) ? 1 : v + 1);
                continue;
            }
            if (i - indexDiff - 1 >= 0) {
                map.compute(nums[i - indexDiff - 1], (k, v) -> v == 1 ? null : v - 1);
            }
            NavigableMap<Integer, Integer> subMap = map.subMap(nums[i] - valueDiff, true, nums[i] + valueDiff, true);
            if (subMap.isEmpty()) {
                map.compute(nums[i], (k, v) -> Objects.isNull(v) ? 1 : v + 1);
                continue;
            }
            return true;
        }
        return false;
    }


}
