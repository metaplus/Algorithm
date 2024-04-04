package problem.graph;

import java.util.*;

public class Lc1136MinimumSemesters {

    public int minimumSemesters(int n, int[][] relations) {
        int[] in = new int[n + 1];
        List<Integer>[] graph = new List[n + 1];
        Arrays.setAll(graph, i -> new ArrayList<>(4));
        for (int[] relation : relations) {
            graph[relation[0]].add(relation[1]);
            in[relation[1]]++;
        }
        Deque<Integer> deque = new ArrayDeque<>();
        int level = 0;
        for (int i = 1; i < in.length; i++) {
            if (in[i] == 0) {
                in[i] = -1;
                deque.add(i);
            }
        }
        while (!deque.isEmpty()) {
            level++;
            int size = deque.size();
            while (size-- > 0) {
                Integer node = deque.pollFirst();
                for (int next : graph[node]) {
                    if (--in[next] == 0) {
                        in[next] = -1;
                        deque.offerLast(next);
                    }
                }
            }
        }
        for (int i = 1; i < in.length; i++) {
            if (in[i] >= 0) {
                return -1;
            }
        }
        return level;
    }

}
