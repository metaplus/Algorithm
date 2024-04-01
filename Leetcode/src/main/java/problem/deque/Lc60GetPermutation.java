package problem.deque;

public class Lc60GetPermutation {

    public String getPermutation(int n, int k) {
        int[] fact = new int[n];
        fact[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            fact[i] = fact[i + 1] * (n - i-1);
        }
        boolean[] visit = new boolean[n + 1];
        StringBuilder builder = new StringBuilder();
        dfs(n, k, builder, fact, visit, 0, 0);
        return builder.toString();
    }

    public void dfs(int n, int k, StringBuilder builder, int[] fact, boolean[] visit, int i, int sum) {
        if (i == n) {
            return;
        }
        for (int digit = 1; digit <= n; digit++) {
            if (visit[digit]) {
                continue;
            }
            if (sum + fact[i ] < k) {
                sum += fact[i ];
                continue;
            }
            visit[digit] = true;
            builder.append(digit);
            dfs(n, k, builder, fact, visit, i + 1, sum);
            return;
        }
    }
}
