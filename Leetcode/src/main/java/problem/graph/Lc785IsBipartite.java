package problem.graph;

public class Lc785IsBipartite {
    public boolean isBipartite(int[][] graph) {
        int[] visit = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (visit[i] > 0) {
                continue;
            }
            if (!dfs(graph, i, visit, true)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int[][] graph, int i, int[] visit, boolean left) {
        if (visit[i] > 0) {
            return left && visit[i] == 1 || !left && visit[i] == 2;
        }
        visit[i] = left ? 1 : 2;
        for (int next : graph[i]) {
            if (!dfs(graph, next, visit, !left)) {
                return false;
            }
        }
        return true;
    }
}
