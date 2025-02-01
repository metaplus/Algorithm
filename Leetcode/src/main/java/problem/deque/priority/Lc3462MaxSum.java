package problem.deque.priority;

import java.util.PriorityQueue;

public class Lc3462MaxSum {

    public long maxSum(int[][] grid, int[] limits, int k) {
        if (k == 0) {
            return 0;
        }
        int rows = grid.length;
        int cols = grid[0].length;
        PriorityQueue<Integer> queue = new PriorityQueue<>(k * 2);
        for (int i = 0; i < rows; i++) {
            if (limits[i] <= 0) {
                continue;
            }
            PriorityQueue<Integer> row = new PriorityQueue<>(limits[i]);
            for (int j = 0; j < cols; j++) {
                int val = grid[i][j];
                if (val > 0) {
                    if (queue.size() == k && val < queue.peek()) {
                        continue;
                    }
                    if (row.size() < limits[i]) {
                        row.add(val);
                        continue;
                    }
                    if (row.peek() < val) {
                        row.poll();
                        row.add(val);
                    }
                }
            }
            queue.addAll(row);
            while (queue.size() > k) {
                queue.poll();
            }
        }
        long sum = 0;
        for (Integer i : queue) {
            sum += i;
        }
        return sum;
    }
}
