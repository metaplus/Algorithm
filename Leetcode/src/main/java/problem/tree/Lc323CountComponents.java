package problem.tree;

import java.util.*;

public class Lc323CountComponents {


    public int countComponents(int n, int[][] edges) {
        int[] roots = new int[n];
        int[] ranks = new int[n];
        Arrays.setAll(roots, i -> i);
        for (int[] edge : edges) {
            int root0 = findRoot(roots, edge[0]);
            int root1 = findRoot(roots, edge[1]);
            if (root0 != root1) {
                if (ranks[root0] > ranks[root1]) {
                    roots[root1] = root0;
                    continue;
                }
                if (ranks[root1] > ranks[root0]) {
                    roots[root0] = root1;
                    continue;
                }
                roots[root0] = root1;
                ranks[root1]++;
            }
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(findRoot(roots, i));
        }
        return set.size();
    }


    int findRoot(int[] roots, int i) {
        while (roots[i] != i) {
            i = roots[i];
        }
        return roots[i];
    }


    public int countComponents2(int n, int[][] edges) {
        int comp = 0;
        List<Integer>[] adg = new List[n];
        for (int[] edge : edges) {
            if (Objects.isNull(adg[edge[0]])) {
                adg[edge[0]] = new ArrayList<>(2);
            }
            adg[edge[0]].add(edge[1]);
            if (Objects.isNull(adg[edge[1]])) {
                adg[edge[1]] = new ArrayList<>(2);
            }
            adg[edge[1]].add(edge[0]);
        }
        boolean[] visit = new boolean[n];
        for (int[] edge : edges) {
            if (visit[edge[0]]) {
                continue;
            }
            comp++;
            Deque<Integer> deque = new ArrayDeque<>();
            deque.offer(edge[0]);
            while (!deque.isEmpty()) {
                int size = deque.size();
                for (int i = 0; i < size; i++) {
                    Integer id = deque.poll();
                    visit[id] = true;
                    if (Objects.nonNull(adg[id]) && !adg[id].isEmpty()) {
                        for (Integer child : adg[id]) {
                            if (visit[child]) {
                                continue;
                            }
                            deque.add(child);
                        }
                    }
                }
            }
        }
        for (boolean v : visit) {
            if (!v) {
                comp++;
            }
        }
        return comp;
    }
}
