package problem.search.dfs;

public class Lc2928DistributeCandies {

    public int distributeCandies(int n, int limit) {
        return dfs(n, limit, 0);
    }

    private int dfs(int remain, int limit, int index) {
        if (remain == 0) {
            return 1;
        }
        int min = Math.max(0, remain - (2 - index) * limit);
        int max = Math.min(limit, remain);
        if (index == 2) {
            return max - min + 1;
        }
        int sum = 0;
        for (int i = min; i <= max; i++) {
            sum += dfs(remain - i, limit, index + 1);
        }
        return sum;
    }

}
