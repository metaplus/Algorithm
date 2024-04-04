package problem.hashmap;

import java.util.HashMap;
import java.util.Map;

public class Lc128LongestConsecutive {

    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> roots = new HashMap<>(nums.length);
        for (int num : nums) {
            roots.put(num, num);
        }
        int lenMax = 0;
        for (Map.Entry<Integer, Integer> entry : roots.entrySet()) {
            if (roots.containsKey(entry.getKey() + 1)) {
                continue;
            }
            int root = entry.getKey() - 1;
            while (roots.containsKey(root)) {
                root--;
            }
//            for (int j = root + 1; j < entry.getKey(); j++) {
//                roots.put(j, root + 1);
//            }
//            entry.setValue(root + 1);
            lenMax = Math.max(lenMax, entry.getKey() - root);
        }
        return lenMax;
    }
}
