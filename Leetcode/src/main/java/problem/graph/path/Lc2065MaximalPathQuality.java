package problem.graph.path;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lc2065MaximalPathQuality {


    private int maxCost = 0;

    public void dfs(int[] values, int index, int leftTime, int sumCost, int[] count, List<int[]>[] graph) {
        if (leftTime < 0) {
            return;
        }
        if (count[index]++ == 0) {
            sumCost += values[index];
        }
        if (index == 0) {
            maxCost = Math.max(maxCost, sumCost);
        }
        for (int[] edge : graph[index]) {
            dfs(values, edge[0], leftTime - edge[1], sumCost, count, graph);
        }
        count[index]--;
    }

    public int maximalPathQuality(int[] values, int[][] edges, int maxTime) {
        List<int[]>[] graph = new List[values.length];
        Arrays.setAll(graph, i -> new ArrayList<>(4));
        for (int[] edge : edges) {
            graph[edge[0]].add(new int[]{edge[1], edge[2]});
            graph[edge[1]].add(new int[]{edge[0], edge[2]});
        }
        dfs(values, 0, maxTime, 0, new int[values.length], graph);
        return maxCost;
    }


}
