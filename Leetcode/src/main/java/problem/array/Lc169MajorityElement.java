package problem.array;

import java.util.HashMap;
import java.util.Map;

public class Lc169MajorityElement {

    public int majorityElement(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            if (count.merge(num, 1, Integer::sum) > nums.length / 2) {
                return num;
            }
        }
        return 0;
    }
}
