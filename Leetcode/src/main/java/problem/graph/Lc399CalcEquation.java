package problem.graph;

import java.util.*;

public class Lc399CalcEquation {

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            graph.computeIfAbsent(equation.get(0), k -> new HashMap<>(4)).put(equation.get(1), values[i]);
            graph.computeIfAbsent(equation.get(1), k -> new HashMap<>(4)).put(equation.get(0), 1 / values[i]);
        }
        double[] result = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            if (!graph.containsKey(queries.get(i).get(0))
                    || !graph.containsKey(queries.get(i).get(1))) {
                result[i] = -1;
                continue;
            }
            if (queries.get(i).get(0).equals(queries.get(i).get(1))) {
                result[i] = 1;
                continue;
            }
            result[i] = dfs(graph, new HashSet<>(8), queries.get(i).get(0), queries.get(i).get(1));
        }
        return result;
    }

    private double dfs(Map<String, Map<String, Double>> graph, Set<String> path, String node, String target) {
        if (!path.add(node)) {
            return -1;
        }
        if (node.equals(target)) {
            path.remove(node);
            return 1;
        }
        Map<String, Double> map = graph.get(node);
        for (Map.Entry<String, Double> entry : map.entrySet()) {
            double next = dfs(graph, path, entry.getKey(), target);
            if (next > 0) {
                return entry.getValue() * next;
            }
        }
        path.remove(node);
        return -1;
    }

}
