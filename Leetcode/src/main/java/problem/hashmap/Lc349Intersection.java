package problem.hashmap;

import java.util.HashSet;
import java.util.Set;

public class Lc349Intersection {

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int i : nums1) {
            set1.add(i);
        }
        for (int i : nums2) {
            if (set1.contains(i)) {
                set2.add(i);
            }
        }
        int[] result = new int[set2.size()];
        int index = 0;
        for (Integer i : set2) {
            result[index++] = i;
        }
        return result;
    }
}
