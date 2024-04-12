package problem.deque.range;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lc57Insert {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> sort = new ArrayList<>(intervals.length + 1);
        Collections.addAll(sort, intervals);
        sort.add(newInterval);
        sort.sort((a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            }
            return b[1] - a[1];
        });
        List<int[]> merge = new ArrayList<>(intervals.length);
        for (int[] interval : sort) {
            if (merge.isEmpty() || merge.get(merge.size() - 1)[1] < interval[0]) {
                merge.add(interval);
                continue;
            }
            merge.get(merge.size() - 1)[1] = Math.max(merge.get(merge.size() - 1)[1], interval[1]);
        }
        return merge.toArray(new int[0][0]);
    }
}
