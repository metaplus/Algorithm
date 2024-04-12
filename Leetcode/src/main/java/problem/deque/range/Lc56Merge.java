package problem.deque.range;

import java.util.*;

public class Lc56Merge {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            }
            return b[1] - a[1];
        });
        Deque<int[]> deque = new ArrayDeque<>();
        int start = -1;
        List<int[]> list = new ArrayList<>();
        for (int[] interval : intervals) {
            if (deque.isEmpty()) {
                start = interval[0];
                deque.offer(interval);
                continue;
            }
            if (interval[0] > deque.peekLast()[1]) {
                list.add(new int[]{start, deque.peekLast()[1]});
                start = interval[0];
                deque.clear();
                deque.offer(interval);
                continue;
            }
            while (!deque.isEmpty() && deque.peekLast()[1] <= interval[1]) {
                deque.pollLast();
            }
            if (deque.isEmpty() || deque.peekLast()[1] <= interval[1]) {
                deque.offer(interval);
            }
        }
        if (!deque.isEmpty()) {
            list.add(new int[]{start, deque.peekLast()[1]});
        }
        return list.toArray(new int[0][0]);
    }

    public int[][] merge2(int[][] intervals) {
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
