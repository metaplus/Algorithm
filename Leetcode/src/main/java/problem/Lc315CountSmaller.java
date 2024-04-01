package problem;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Lc315CountSmaller {

    //timeout
    public List<Integer> countSmaller(int[] nums) {
        TreeMap<Integer, Integer> counts = new TreeMap<>();
        List<Integer> res = new ArrayList<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            res.add(0);
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            int sum = 0;
            for (Map.Entry<Integer, Integer> entry : counts.headMap(nums[i]).entrySet()) {
                sum += entry.getValue();
            }
            res.set(i, sum);
            counts.merge(nums[i], 1, Integer::sum);
        }
        return res;
    }
}
