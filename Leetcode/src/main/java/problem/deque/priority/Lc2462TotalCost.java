package problem.deque.priority;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Lc2462TotalCost {

    public long totalCost(int[] costs, int k, int candidates) {
        if (candidates * 2 + k > costs.length) {
            Arrays.sort(costs);
            long cost = 0;
            for (int i = 0; i < k; i++) {
                cost += costs[i];
            }
            return cost;
        }
        PriorityQueue<Cell> queue = new PriorityQueue<>(candidates * 2,
                (a, b) -> {
                    if (a.val != b.val) {
                        return Integer.compare(a.val, b.val);
                    }
                    return Integer.compare(a.index, b.index);
                });
        int left = 0;
        int right = costs.length - 1;
        while (left < candidates) {
            right = costs.length - 1 - left;
            if (left > right) {
                break;
            }
            if (left == right) {
                queue.offer(new Cell(costs[left++], left, true));
                break;
            }
            queue.offer(new Cell(costs[left++], left, true));
            queue.offer(new Cell(costs[right--], right, false));
        }
        long cost = 0;
        int count = 0;
        while (!queue.isEmpty() && count++ < k) {
            Cell cell = queue.poll();
            cost += cell.val;
            if (left > right) {
                continue;
            }
            if (left == right) {
                queue.offer(new Cell(costs[left++], left, true));
                continue;
            }
            if (cell.left) {
                queue.offer(new Cell(costs[left++], left, true));
                continue;
            }
            queue.offer(new Cell(costs[right--], right, false));
        }
        return cost;
    }

    private static class Cell {
        private int val;
        private int index;
        private boolean left;

        public Cell(int val, int index, boolean left) {
            this.val = val;
            this.index = index;
            this.left = left;
        }

        @Override
        public String toString() {
            return "Cell{" +
                    "val=" + val +
                    ", index=" + index +
                    ", left=" + left +
                    '}';
        }
    }
}
