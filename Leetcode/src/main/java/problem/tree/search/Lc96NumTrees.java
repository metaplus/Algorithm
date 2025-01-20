package problem.tree.search;

public class Lc96NumTrees {

    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp[n];
    }

    public int numTrees2(int n) {
        return dfs(1, n, new int[20]);
    }

    public int dfs(int left, int right, int[] map) {
        if (left == right) {
            return 1;
        }
        if (left + 1 == right) {
            return 2;
        }
        if (map[right - left] > 0) {
            return map[right - left];
        }
        int sum = 0;
        sum += dfs(left + 1, right, map);
        sum += dfs(left, right - 1, map);
        for (int i = left + 1; i < right; i++) {
            sum += dfs(left, i - 1, map) * dfs(i + 1, right, map);
        }
        return map[right - left] = sum;
    }
}
