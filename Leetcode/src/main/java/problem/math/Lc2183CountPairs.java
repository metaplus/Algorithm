package problem.math;

import java.util.ArrayList;
import java.util.HashMap;

public class Lc2183CountPairs {

    public long countPairs(int[] nums, int k) {
        var divisors = new ArrayList<Integer>(); // 预处理 k 的所有因子
        for (var d = 1; d * d <= k; d++) {
            if (k % d == 0) {
                divisors.add(d);
                if (d * d < k) divisors.add(k / d);
            }
        }
        var ans = 0L;
        var cnt = new HashMap<Integer, Integer>();
        for (var v : nums) {
            ans += cnt.getOrDefault(k / gcd(v, k), 0);
            for (var d : divisors)
                if (v % d == 0)
                    cnt.put(d, cnt.getOrDefault(d, 0) + 1);
        }
        return ans;
    }

    static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

}
