package problem.tree;

import java.util.*;

public class Lc1245TreeDiameter {

    public int treeDiameter(int[][] edges) {
        if (edges.length < 1) {
            return 0;
        }
        int max = edges[0][0];
        for (int[] edge : edges) {
            max = Math.max(max, edge[0]);
            max = Math.max(max, edge[1]);
        }
        List<Integer>[] graph = new List[max + 1];
        Arrays.setAll(graph, i -> new ArrayList<>(4));
        int[] degree = new int[max + 1];
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
            degree[edge[0]]++;
            degree[edge[1]]++;
        }
        Deque<Integer> deque = new ArrayDeque<>();
        int level = 0;
        for (int i = 0; i < degree.length; i++) {
            if (degree[i] == 1) {
                deque.add(i);
            }
        }
        int remain = max + 1;
        while (!deque.isEmpty() && remain > 2) {
            int size = deque.size();
            remain -= size;
            level++;
            while (size-- > 0) {
                for (Integer next : graph[deque.peek()]) {
                    if (--degree[next] == 1) {
                        deque.add(next);
                    }
                }
                deque.poll();
            }
        }
        return level * 2 + remain - 1;
    }
}
