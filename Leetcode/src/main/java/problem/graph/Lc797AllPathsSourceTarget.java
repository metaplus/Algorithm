package problem.graph;

import java.util.ArrayList;
import java.util.List;

public class Lc797AllPathsSourceTarget {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(graph, 0, new ArrayList<>(), res);
        return res;

    }

    private void dfs(int[][] graph, int i, List<Integer> path, List<List<Integer>> res) {
        if (i == graph.length - 1) {
            path.add(i);
            res.add(new ArrayList<>(path));
            path.remove(path.size() - 1);
            return;
        }
        if (graph[i].length == 0) {
            return;
        }
        path.add(i);
        for (int next : graph[i]) {
            dfs(graph, next, path, res);
        }
        path.remove(path.size() - 1);
    }
}
