package problem.graph;

import java.util.*;

public class Lc2642Graph {

    class Graph {

        private List<int[]>[] graph;

        public Graph(int n, int[][] edges) {
            graph = new List[n];
            Arrays.setAll(graph, (i) -> new ArrayList<>(4));
            for (int[] edge : edges) {
                graph[edge[0]].add(new int[]{edge[1], edge[2]});
            }
        }

        public void addEdge(int[] edge) {
            graph[edge[0]].add(new int[]{edge[1], edge[2]});
        }

        public int shortestPath(int node1, int node2) {
            int[] dist = new int[graph.length];
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[node1] = 0;
            PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(arr -> arr[1]));
            queue.offer(new int[]{node1, 0});
            while (!queue.isEmpty()) {
                int[] node = queue.poll();
                if (node[0] == node2) {
                    return node[1];
                }
                for (int[] next : graph[node[0]]) {
                    int cost = node[1] + next[1];
                    if (cost < dist[next[0]]) {
                        dist[next[0]] = cost;
                        queue.offer(new int[]{next[0], cost});
                    }
                }
            }
            return -1;
        }
    }

/**
 * Your Graph object will be instantiated and called as such:
 * Graph obj = new Graph(n, edges);
 * obj.addEdge(edge);
 * int param_2 = obj.shortestPath(node1,node2);
 */
}
