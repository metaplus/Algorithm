package problem.hashmap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Lc128LongestConsecutive {

    public int longestConsecutive(int[] nums) {
        Set<Integer > set=new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int lenMax=0;
        for (Integer i : set) {
            if(set.contains(i-1)){
                continue;
            }
            int len=0;
            int val=i;
            while (set.contains(val)){
                val++;
                len++;
            }
            lenMax=Math.max(lenMax,len);
        }
        return lenMax;
    }

        public int longestConsecutive2(int[] nums) {
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
