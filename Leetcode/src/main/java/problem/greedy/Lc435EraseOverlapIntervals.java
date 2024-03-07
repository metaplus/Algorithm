package problem.greedy;

import java.util.Arrays;

public class Lc435EraseOverlapIntervals {

    public int eraseOverlapIntervals(int[][] intervals) {
        radixSort(intervals);
        int count = 1;
        int right = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= right) {
                count++;
                right = intervals[i][1];
            }
        }
        return intervals.length - count;
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
