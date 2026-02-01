package problem.sort;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Lc1833MaxIceCream {

    public int maxIceCream(int[] costs, int coins) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        int sum = 0;
        for (int cost : costs) {
            if (cost + sum <= coins) {
                queue.add(cost);
                sum += cost;
                continue;
            }
            if (!queue.isEmpty() && queue.peek() > cost) {
                sum -= queue.poll();
                sum += cost;
                queue.add(cost);
            }
        }
        return queue.size();
    }
}
