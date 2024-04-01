package problem.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lc787FindCheapestPrice {


    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[][] dp = new int[k + 2][n];
        int inf = Integer.MAX_VALUE / 2;
        for (int[] row : dp) {
            Arrays.fill(row, inf);
        }
        dp[0][src] = 0;
        for (int i = 1; i <= k + 1; i++) {
            for (int[] flight : flights) {
                dp[i][flight[1]] = Math.min(dp[i][flight[1]], dp[i - 1][flight[0]] + flight[2]);
            }
        }
        int costMin = inf;
        for (int i = 1; i <= k + 1; i++) {
            costMin = Math.min(costMin, dp[i][dst]);
        }
        return costMin < inf ?costMin : -1;
    }

    //timeout
    public int findCheapestPrice2(int n, int[][] flights, int src, int dst, int k) {
        List<int[]>[] adj = new List[n];
        Arrays.setAll(adj, i -> new ArrayList<>(4));
        for (int[] flight : flights) {
            adj[flight[0]].add(flight);
        }
        int cost = dfs(adj, src, dst, k, src, new boolean[n], 0, 0, Integer.MAX_VALUE);
        return cost < Integer.MAX_VALUE ? cost : -1;
    }


    public int dfs(List<int[]>[] adj, int src, int dst, int k, int i, boolean[] visit, int cost, int edges, int costMin) {
        if (visit[i]) {
            return Integer.MAX_VALUE;
        }
        if (i == dst) {
            return cost;
        }
        if (k == edges && i != src) {
            return Integer.MAX_VALUE;
        }
        if (i != src) {
            edges++;
        }
        if (cost >= costMin || adj[i].isEmpty()) {
            return Integer.MAX_VALUE;
        }
        visit[i] = true;
        for (int[] flight : adj[i]) {
            costMin = Math.min(dfs(adj, src, dst, k, flight[1], visit, cost + flight[2], edges, costMin), costMin);
        }
        visit[i] = false;
        return costMin;
    }
}
