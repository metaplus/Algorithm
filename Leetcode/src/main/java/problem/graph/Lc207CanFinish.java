package problem.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lc207CanFinish {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites.length < 1) {
            return true;
        }
        List<Integer>[] adj = new List[numCourses];
        Arrays.setAll(adj, i -> new ArrayList<>(4));
        for (int[] prerequisite : prerequisites) {
            adj[prerequisite[1]].add(prerequisite[0]);
        }
        int[] visit = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (adj[i].isEmpty() || visit[i] > 0) {
                continue;
            }
            if (!dfs(i, visit, adj)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int i, int[] visit, List<Integer>[] adj) {
        if (visit[i] == 1) {
            return false;
        }
        if (visit[i] == 2) {
            return true;
        }
        visit[i] = 1;
        for (Integer j : adj[i]) {
            if (!dfs(j, visit, adj)) {
                return false;
            }
        }
        visit[i] = 2;
        return true;
    }
}
