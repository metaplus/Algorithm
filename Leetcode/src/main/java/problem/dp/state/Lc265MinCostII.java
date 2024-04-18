package problem.dp.state;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Lc265MinCostII {

    // time long
    public int minCostII(int[][] costs) {
        PriorityQueue<int[]> dp = new PriorityQueue<>(costs[0].length, Comparator.comparingInt(arr -> arr[1]));
        for (int i = 0; i < costs.length; i++) {
            PriorityQueue<int[]> next = new PriorityQueue<>(costs[0].length, Comparator.comparingInt(arr -> arr[1]));
            for (int j = 0; j < costs[i].length; j++) {
                if (!dp.isEmpty() && dp.peek()[0] == j) {
                    int[] min = dp.poll();
                    next.offer(new int[]{j, dp.peek()[1] + costs[i][j]});
                    dp.offer(min);
                    continue;
                }
                next.offer(new int[]{j, (dp.isEmpty() ? 0 : dp.peek()[1]) + costs[i][j]});
            }
            dp.clear();
            dp.addAll(next);
            next.clear();
        }
        return dp.peek()[1];
    }
}
