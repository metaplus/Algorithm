package problem.array.substring;

import java.util.*;

public class Lc3144MinimumSubstringsInPartition {

    private static final int INF = Integer.MAX_VALUE / 2;
    private Map<Integer, Integer> cache = new HashMap<>();

    private static boolean isBalance(Map<Character, Integer> counts) {
        if (counts.size() < 2) {
            return true;
        }
        Integer same = null;
        for (Integer value : counts.values()) {
            if (Objects.isNull(same) || same.equals(value)) {
                same = value;
                continue;
            }
            return false;
        }
        return true;
    }

    public int minimumSubstringsInPartition(String s) {
        char[] chars = s.toCharArray();
        List<Integer>[] bounds = new List[s.length()];
        for (int i = 0; i < s.length(); i++) {
            bounds[i] = new ArrayList<>(4);
            Map<Character, Integer> counts = new HashMap<>();
            for (int j = i; j < s.length(); j++) {
                counts.merge(chars[j], 1, Integer::sum);
                if (isBalance(counts)) {
                    bounds[i].add(j);
                }
            }
        }
        return dfs(bounds, chars, 0);
    }

    private int dfs(List<Integer>[] bounds, char[] chars, int left) {
        if (left == chars.length) {
            return 0;
        }
        if (bounds[left].isEmpty()) {
            return INF;
        }
        Integer result = cache.get(left);
        if (Objects.nonNull(result)) {
            return result;
        }
        int nextCut = INF;
        for (Integer right : bounds[left]) {
            nextCut = Math.min(nextCut, dfs(bounds, chars, right + 1));
        }
        result = nextCut != INF ? nextCut + 1 : INF;
        cache.put(left, result);
        return result;
    }
}
