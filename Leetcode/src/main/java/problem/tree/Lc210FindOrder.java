package problem.tree;

import java.util.*;

public class Lc210FindOrder {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new List[numCourses];
        Arrays.setAll(graph, i -> new ArrayList<>(4));
        int[] degree = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            graph[prerequisite[1]].add(prerequisite[0]);
            degree[prerequisite[0]]++;
        }
        List<Integer> result = new ArrayList<>(numCourses);
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < degree.length; i++) {
            if (degree[i] == 0) {
                deque.add(i);
            }
        }
        while (!deque.isEmpty()) {
            int size = deque.size();
            while (size-- > 0) {
                result.add(deque.peek());
                for (Integer next : graph[deque.peek()]) {
                    if (--degree[next] == 0) {
                        deque.add(next);
                    }
                }
                deque.poll();
            }
        }
        for (int i = 0; i < degree.length; i++) {
            if (degree[i] > 0) {
                return new int[0];
            }
        }
        int[] arr = new int[result.size()];
        Arrays.setAll(arr, result::get);
        return arr;
    }
}
