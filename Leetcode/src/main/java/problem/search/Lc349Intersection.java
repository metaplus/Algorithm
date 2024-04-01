package problem.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lc349Intersection {

    public int[] intersection(int[] nums1, int[] nums2) {
        int[] count = new int[1001];
        for (int i : nums1) {
            count[i]++;
        }
        List<Integer> res = new ArrayList<>();
        for (int i : nums2) {
            if (count[i] <= 0) {
                continue;
            }
            count[i] *= -1;
            res.add(i);
        }
        int[] res1 = new int[res.size()];
        Arrays.setAll(res1, res::get);
        return res1;
    }
}
