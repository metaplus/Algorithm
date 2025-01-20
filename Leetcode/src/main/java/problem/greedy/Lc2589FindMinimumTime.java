package problem.greedy;

import java.util.Arrays;
import java.util.Objects;
import java.util.TreeSet;

public class Lc2589FindMinimumTime {

    // time long
    public int findMinimumTime(int[][] tasks) {
        Arrays.sort(tasks, (a, b) -> {
            if (a[1] != b[1]) {
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(b[0], a[0]);
        });
        TreeSet<Integer> set = new TreeSet<>();
        for (int[] task : tasks) {
            int left = task[0];
            while (task[2] > 0) {
                Integer ceil = set.ceiling(left);
                if (Objects.isNull(ceil)
                        || ceil > task[1]) {
                    break;
                }
                task[2]--;
                left = ceil + 1;
            }
            int right = task[1];
            while (task[2] > 0) {
                while (!set.add(right)) {
                    right--;
                }
                right--;
                task[2]--;
            }
        }
        return set.size();
    }
}
