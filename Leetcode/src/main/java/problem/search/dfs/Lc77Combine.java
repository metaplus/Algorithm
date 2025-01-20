package problem.search.dfs;

import java.util.ArrayList;
import java.util.List;

public class Lc77Combine {
    public List<List<Integer>> combine(int n, int k) {
        if (k <= 0 || n < k) {
            return new ArrayList<>();
        }
        List<Integer> builder = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 1; i <= n - k + 1; i++) {
            dfs(n, k, i, builder, res);
        }
        return res;
    }

    private void dfs(int n, int k, int i, List<Integer> builder, List<List<Integer>> res) {
        builder.add(i);
        if (builder.size() == k) {
            res.add(new ArrayList<>(builder));
            builder.remove(k - 1);
            return;
        }
        for (int j = i + 1; j <= n - (k - builder.size()) + 1; j++) {
            dfs(n, k, j, builder, res);
        }
        builder.remove(builder.size() - 1);
    }
}
