package problem.hashmap;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Lc219ContainsNearbyDuplicate {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer j = map.get(nums[i]);
            if (Objects.nonNull(j)
                    && i - j <= k) {
                return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }
}
