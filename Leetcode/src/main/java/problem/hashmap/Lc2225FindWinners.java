package problem.hashmap;

import java.util.*;

public class Lc2225FindWinners {

    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, Integer> lose = new HashMap<>();
        for (int[] match : matches) {
            lose.merge(match[0], 0, Integer::sum);
            lose.merge(match[1], 1, Integer::sum);
        }
        List<List<Integer>> result = new ArrayList<>(2);
        result.add(new ArrayList<>());
        result.add(new ArrayList<>());
        for (Map.Entry<Integer, Integer> entry : lose.entrySet()) {
            if (entry.getValue() == 0) {
                result.get(0).add(entry.getKey());
                continue;
            }
            if (entry.getValue() == 1) {
                result.get(1).add(entry.getKey());
            }
        }
        result.get(0).sort(Comparator.naturalOrder());
        result.get(1).sort(Comparator.naturalOrder());
        return result;
    }
}
