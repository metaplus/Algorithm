package problem.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Lc1229MinAvailableDuration {

    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        Arrays.sort(slots1, Comparator.comparingInt(a -> a[0]));
        Arrays.sort(slots2, Comparator.comparingInt(a -> a[0]));
        List<Integer> win = new ArrayList<>(2);
        for (int left = 0, right = 0; left < slots1.length && right < slots2.length; ) {
            if (slots1[left][0] >= slots2[right][1]) {
                right++;
                continue;
            }
            if (slots1[left][1] <= slots2[right][0]) {
                left++;
                continue;
            }
            int start = Math.max(slots1[left][0], slots2[right][0]);
            int end = Math.min(slots1[left][1], slots2[right][1]);
            if (end - start >= duration) {
                win.add(start);
                win.add(start + duration);
                return win;
            }
            if (slots1[left][1] < slots2[right][1]) {
                left++;
                continue;
            }
            right++;
        }
        return win;
    }
}
