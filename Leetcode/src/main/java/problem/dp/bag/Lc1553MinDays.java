package problem.dp.bag;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Lc1553MinDays {


    private Map<Integer, Integer> cache = new HashMap<>();


    public int minDays(int n) {
        return dfs(n);
    }

    private int dfs(int n) {
        if (n <= 1) {
            return n;
        }
        Integer result = cache.get(n);
        if (Objects.nonNull(result)) {
            return result;
        }
        result = dfs(n / 2) + 1 + n % 2;
        result = Math.min(result, dfs(n / 3) + 1 + n % 3);
        cache.put(n, result);
        return result;
    }


    // oom
    public int minDays2(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1] + 1;
            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }
            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }
        }
        return dp[n];
    }
}
