package problem.greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Lc253MinMeetingRooms {

    public int minMeetingRooms(int[][] intervals) {
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
