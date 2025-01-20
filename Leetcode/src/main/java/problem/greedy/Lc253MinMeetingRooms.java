package problem.greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;

public class Lc253MinMeetingRooms {

    public int minMeetingRooms(int[][] intervals) {
        Integer[] queue = new Integer[intervals.length * 2];
        for (int i = 0; i < intervals.length; i++) {
            queue[i * 2] = intervals[i][0];
            queue[i * 2 + 1] = -intervals[i][1];
        }
        Arrays.sort(queue, (a, b) -> {
            int sub = Math.abs(a) - Math.abs(b);
            if (sub != 0) {
                return sub;
            }
            if (a + b != 0) {
                return sub;
            }
            return a < 0 ? -1 : 1;
        });
        int max = 0;
        int count = 0;
        for (Integer i : queue) {
            if (i >= 0) {
                if (++count > max) {
                    max = count;
                }
                continue;
            }
            --count;
        }
        return max;
    }

    public int minMeetingRooms3(int[][] intervals) {
        if (intervals.length < 2) {
            return intervals.length;
        }
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            }
            return -a[1] + b[1];
        });
        PriorityQueue<Cell> queue = new PriorityQueue<>(Comparator.comparingInt(c -> c.end));
        for (int[] interval : intervals) {
            if (queue.isEmpty() || queue.peek().end > interval[0]) {
                queue.offer(new Cell(interval[1]));
                continue;
            }
            Cell cell = queue.poll();
            cell.end = interval[1];
            queue.offer(cell);
        }
        return queue.size();
    }

    public int minMeetingRooms2(int[][] intervals) {
        if (intervals.length < 2) {
            return intervals.length;
        }
        Arrays.sort(intervals, (a, b) -> {
            if (a[1] != b[1]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });
        PriorityQueue<Cell> queue = new PriorityQueue<>(Comparator.comparingInt(c -> c.end));
        for (int[] interval : intervals) {
            if (queue.isEmpty() || queue.peek().end > interval[0]) {
                queue.offer(new Cell(interval[1]));
                continue;
            }
            Cell cell = queue.poll();
            cell.end = interval[1];
            queue.offer(cell);
        }
        return queue.size();
    }

    private static class Cell {
        int end;

        public Cell(int end) {
            this.end = end;
        }

        @Override
        public String toString() {
            return "Cell{" +
                    "end=" + end +
                    '}';
        }
    }
}
