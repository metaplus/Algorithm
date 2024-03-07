package problem.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lc56Merge {

    public int[][] merge(int[][] intervals) {
        if (intervals.length < 2) {
            return intervals;
        }
        radixSort(intervals);
        List<int[]> partitions = new ArrayList<>(4);
        for (int i = intervals.length - 1; i >= 0; i--) {
            if (intervals[i][0] < 0) {
                continue;
            }
            int left = intervals[i][0];
            int right = intervals[i][1];
            for (int j = i - 1; j >= 0; j--) {
                if (intervals[j][0] < 0
                        || intervals[j][0] > right
                        || intervals[j][1] < left) {
                    continue;
                }
                left = Math.min(intervals[j][0], left);
                right = Math.max(intervals[j][1], right);
                intervals[j][0] = -1;
            }

            partitions.add(new int[]{left, right});
        }
        return partitions.toArray(new int[0][0]);
    }

    private void radixSort(int[][] intervals) {
        if (intervals.length < 2) {
            return;
        }
        int max = intervals[0][0];
        for (int[] row : intervals) {
            max = Math.max(max, row[1]);
        }
        int digit = findDigit(max);
        int[] counts = new int[19];
        int[][] sort = new int[intervals.length][2];
        int div = 1;
        for (int i = 0; i < digit; i++) {
            for (int[] row : intervals) {
                counts[(row[1] / div) % 10 + 9]++;
            }
            for (int j = 1; j < counts.length; j++) {
                counts[j] += counts[j - 1];
            }
            for (int j = intervals.length - 1; j >= 0; j--) {
                sort[--counts[(intervals[j][1] / div) % 10 + 9]] = intervals[j];
            }
            div *= 10;
            Arrays.fill(counts, 0);
            System.arraycopy(sort, 0, intervals, 0, intervals.length);
        }
    }

    private int findDigit(int max) {
        int digit = 0;
        for (int i = max; i > 0; i /= 10) {
            digit++;
        }
        return digit;
    }
}
