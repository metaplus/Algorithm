package problem.deque;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Lc378KthSmallest {

    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(k, Comparator.reverseOrder());
        for (int[] row : matrix) {
            for (int col : row) {
                if (queue.size() < k) {
                    queue.add(col);
                    continue;
                }
                if (col >= queue.peek()) {
                    continue;
                }
                queue.poll();
                queue.offer(col);
            }
        }
        return queue.peek();
    }
}
