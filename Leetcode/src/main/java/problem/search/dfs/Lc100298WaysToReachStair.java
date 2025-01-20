package problem.search.dfs;

import java.util.Arrays;

public class Lc100298WaysToReachStair {

    private int[][] cache;

    public int waysToReachStair(int k) {
        cache = new int[k * 2][2];
        for (int[] arr : cache) {
            Arrays.fill(arr, -1);
        }
        return dfs(k, 1, 0) + dfs(k, 1, 1);
    }

    public int dfs(int k, int i, int back) {
        if (i < 0) {
            return 0;
        }
        if (cache[i][back] >= 0) {
            return cache[i][back];
        }
        int sum = i == k ? 1 : 0;
        int increment = 1;
        while (i - increment >= 0) {
            sum += dfs(k, i - increment, 0);
            sum += dfs(k, i - increment, 1);
            increment <<= 1;
        }
        sum += dfs(k, i + 1, 0);
        return cache[i][back] = sum;
    }
}
