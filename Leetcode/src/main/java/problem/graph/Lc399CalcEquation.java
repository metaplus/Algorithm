package problem.graph;

import java.util.*;

public class Lc399CalcEquation {


    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        Map<String, Map<String, Double>> graph = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            List<String> eq = equations.get(i);
            graph.computeIfAbsent(eq.get(0), ignore -> new HashMap<>())
                    .put(eq.get(1), values[i]);
            graph.computeIfAbsent(eq.get(1), ignore -> new HashMap<>())
                    .put(eq.get(0), 1 / values[i]);
        }
        double[] result = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            if (!graph.containsKey(query.get(0))) {
                result[i] = -1;
                continue;
            }
            Deque<State> deque = new ArrayDeque<>();
            Set<String> duplicate = new HashSet<>();
            deque.addLast(new State(query.get(0), 1));
            duplicate.add(query.get(0));
            State find = null;
            while (!deque.isEmpty()) {
                int size = deque.size();
                for (int j = 0; j < size; j++) {
                    State state = deque.removeFirst();
                    if (state.divider.equals(query.get(1))) {
                        find = state;
                        break;
                    }
                    Map<String, Double> next = graph.get(state.divider);
                    if (Objects.isNull(next)) {
                        continue;
                    }
                    for (Map.Entry<String, Double> entry : next.entrySet()) {
                        if (duplicate.add(entry.getKey())) {
                            deque.addLast(new State(entry.getKey(), entry.getValue() * state.multiply));
                        }
                    }
                }
            }
            if (Objects.isNull(find)) {
                result[i] = -1;
                continue;
            }
            result[i] = find.multiply;
        }
        return result;
    }

    public double[] calcEquation2(List<List<String>> equations, double[] values, List<List<String>> queries) {
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

    private static class State {

        private final String divider;
        private final double multiply;

        public State(String divider, double multiply) {
            this.divider = divider;
            this.multiply = multiply;
        }
    }

}
