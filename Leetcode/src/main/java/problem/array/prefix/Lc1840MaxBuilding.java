package problem.array.prefix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Lc1840MaxBuilding {



    // tle
    public int maxBuilding(int n, int[][] restrictions) {
        if (restrictions.length > 1) {
            Arrays.sort(restrictions, Comparator.comparingInt(item -> item[0]));
        }
        List<int[]> prefix = new ArrayList<>();
        int restId = 0;
        prefix.add(new int[]{1, 1, 0, 0});
        for (int i = 2; i <= n; i++) {
            int[] tail = prefix.get(prefix.size() - 1);
            if (restId < restrictions.length && restrictions[restId][0] == i) {
                if (restrictions[restId][1] >= tail[3] + 1) {
                    tail[1] = i;
                    tail[3]++;
                } else {
                    prefix.add(new int[]{i, i, restrictions[restId][1], restrictions[restId][1]});
                }
                restId++;
                continue;
            }
            tail[1] = i;
            tail[3]++;
        }
        int result = prefix.get(prefix.size() - 1)[3];
        for (int i = prefix.size() - 2; i >= 0; i--) {
            int[] range = prefix.get(i);
            int[] next = prefix.get(i + 1);
            if (range[3] > next[2] + 1) {
                range[3] = next[2] + 1;
                range[2] = Math.min(range[2], range[3] - range[0] + range[1]);
                result = Math.max(result, range[3]);
                if (range[1] > range[0]) {
                    result = Math.max(result, range[2]);
                    if (range[1] > range[0] + 1) {
                        int window = range[1] - range[0] - Math.abs(range[3] - range[2]);
                        result = Math.max(result, Math.max(range[2], range[3]) + (window >> 1));
                    }
                }
                continue;
            }
            result = Math.max(result, range[3]);
        }

        return result;
    }

    // OOM
    public int maxBuilding2(int n, int[][] restrictions) {

        int[] prefixMax = new int[n + 1];
        Arrays.fill(prefixMax, Integer.MAX_VALUE);
        prefixMax[0] = 0;
        prefixMax[1] = 0;
        for (int[] restriction : restrictions) {
            prefixMax[restriction[0]] = restriction[1];
        }
        for (int i = 2; i <= n; i++) {
            prefixMax[i] = Math.min(prefixMax[i], prefixMax[i - 1] + 1);
        }
        int result = prefixMax[n];
        for (int i = n - 1; i > 0; i--) {
            prefixMax[i] = Math.min(prefixMax[i], prefixMax[i + 1] + 1);
            result = Math.max(result, prefixMax[i]);
        }
        return result;
    }
}
