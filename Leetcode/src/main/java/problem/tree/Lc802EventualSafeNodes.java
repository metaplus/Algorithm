package problem.tree;

import java.util.ArrayList;
import java.util.List;

public class Lc802EventualSafeNodes {

    public boolean dfs(int[][] graph, int i, int[] visit) {
        if (visit[i] > 0) {
            return visit[i] == 2;
        }
        visit[i] = 1;
        for (int next : graph[i]) {
            if (!dfs(graph, next, visit)) {
                return false;
            }
        }
        visit[i] = 2;
        return true;
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> result = new ArrayList<>();
        int[] visit = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (dfs(graph, i, visit)) {
                result.add(i);
            }
        }
        return result;
    }
}
