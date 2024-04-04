package problem.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Lc2192GetAncestors {

    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<Integer>[] reverse = new List[n];
        Arrays.setAll(reverse, i -> new ArrayList<>(4));
        for (int[] edge : edges) {
            reverse[edge[1]].add(edge[0]);
        }
        List<List<Integer>> res = new ArrayList<>(n);
        boolean[] visit = new boolean[n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(visit, false);
            List<Integer> path = new ArrayList<>(8);
            dfs(reverse, i, i, path, visit);
            path.sort(Comparator.naturalOrder());
            res.add(path);
        }
        return res;
    }

    private void dfs(List<Integer>[] reverse, int i, int j, List<Integer> path, boolean[] visit) {
        if (visit[j]) {
            return;
        }
        visit[j] = true;
        if (i != j) {
            path.add(j);
        }
        for (Integer next : reverse[j]) {
            dfs(reverse, i, next, path, visit);
        }
    }
}
