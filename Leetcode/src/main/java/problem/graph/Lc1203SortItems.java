package problem.graph;

import java.util.*;

public class Lc1203SortItems {


    //fail
    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        List<Integer>[] graph = new List[n];
        Arrays.setAll(graph, i -> new ArrayList<>(4));
        int[] inDegree = new int[n];
        for (int i = 0; i < beforeItems.size(); i++) {
            for (Integer pre : beforeItems.get(i)) {
                graph[pre].add(i);
                inDegree[i]++;
            }
        }
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                deque.add(i);
            }
        }
        List<int[]> list = new ArrayList<>();
        int level = 0;
        while (!deque.isEmpty()) {
            int size = deque.size();
            level++;
            while (size-- > 0) {
                Integer item = deque.poll();
                list.add(new int[]{item, list.size(), group[item] < 0 ? m : group[item], level});
                for (Integer next : graph[item]) {
                    if (--inDegree[next] == 0) {
                        deque.offer(next);
                    }
                }
            }
        }
        if (list.size() != n) {
            return new int[0];
        }
        for (int i = 0; i < group.length; i++) {
            if (group[i] < 0) {
                group[i] = m;
            }
        }
//        Arrays.sort(group, Comparator.comparingInt(g -> {
//
//
//        }));
        int[] groupSort = new int[m + 1];
        for (int i = 0; i < list.size(); i++) {
            if (groupSort[list.get(i)[2]] == 0) {
                groupSort[list.get(i)[2]] = list.get(i)[3];
            }
        }
        list.sort((a, b) -> {
            if (a[2] != b[2]) {
                return groupSort[a[2]] - groupSort[b[2]];
            }
            return a[1] - b[1];
        });
        int[] result = new int[list.size()];
        Arrays.setAll(result, i -> list.get(i)[0]);
        return result;
    }
}
