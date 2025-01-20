package problem.greedy;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Lc826MaxProfitAssignment {

    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] workers) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> Integer.compare(b[1], a[1]));
        for (int i = 0; i < difficulty.length; i++) {
            queue.offer(new int[]{difficulty[i], profit[i]});
        }
        Arrays.sort(workers);
        int sum = 0;
        for (int i = workers.length - 1; i >= 0; i--) {
            while (!queue.isEmpty()
                    && queue.peek()[0] > workers[i]) {
                queue.remove();
            }
            if (queue.isEmpty()) {
                return sum;
            }
            sum += queue.peek()[1];
        }
        return sum;
    }


}
