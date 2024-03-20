package problem.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Lc310FindMinHeightTrees {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
            if (n < 3) {
                List<Integer> res = new ArrayList<>(n);
                for (int i = 0; i < n; i++) {
                    res.add(i);
                }
                return res;
            }
        List<Integer>[] adj = new List[n];
        int[] degree = new int[n];
        for (int[] edge : edges) {
            degree[edge[0]]++;
            degree[edge[1]]++;
            if (Objects.isNull(adj[edge[0]])) {
                adj[edge[0]] = new ArrayList<>(4);
            }
            adj[edge[0]].add(edge[1]);
            if (Objects.isNull(adj[edge[1]])) {
                adj[edge[1]] = new ArrayList<>(4);
            }
            adj[edge[1]].add(edge[0]);
        }
        ArrayDeque<Integer> deque = new ArrayDeque<>(n);
        for (int i = 0; i < degree.length; i++) {
            if (degree[i] == 1) {
                deque.add(i);
            }
        }
        int remain = n;
        while (remain > 2) {
            int size = deque.size();
            remain -= deque.size();
            for (int i = 0; i < size; i++) {
                Integer node = deque.poll();
                for (Integer next : adj[node]) {
                    if (--degree[next] == 1) {
                        deque.offer(next);
                    }
                }
            }
        }
        return new ArrayList<>(deque);
    }
}
