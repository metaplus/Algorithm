package problem.greedy;

import java.util.ArrayList;
import java.util.List;

public class Lc2834MinimumPossibleSum {

    private static final int MOD = (int) 1e9 + 7;

    public int minimumPossibleSum(int n, int target) {
        if (n == 1) {
            return 1;
        }
        long sum = 0;
        int count = 0;
//        List<Integer> path = new ArrayList<>();
        for (int i = 1; i <= n && i <= (target) / 2 && count <= n; i++, count++) {
            sum += i;
//            path.add(i);
        }
        for (int i = 0; i < n - count; i++) {
            sum += i + target;
//            path.add(i + target);
        }
        int result = (int) (sum % MOD);
        return result;
    }
}
