package problem.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

public class Lc279NumSquares {

    public int numSquares(int n) {
        List<Integer> squares = new ArrayList<>(32);
        for (int i = 1; i <= n; i++) {
            int mul = i * i;
            if (mul > n) {
                break;
            }
            if (mul == n) {
                return 1;
            }
            squares.add(mul);
        }
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            for (Integer square : squares) {
                if (i - square < 0) {
                    break;
                }
                if (dp[i - square] > 0 || i - square == 0) {
                    if (dp[i] > 0) {
                        dp[i] = Math.min(dp[i], dp[i - square] + 1);
                    } else {
                        dp[i] = dp[i - square] + 1;
                    }
                }
            }
        }
        return dp[n];
    }

    public int numSquares3(int n) {
        List<Integer> elements = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            int mul = i * i;
            if (mul > n) {
                break;
            }
            elements.add(mul);
        }
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (Integer element : elements) {
                if (i - element < 0) {
                    break;
                }
                dp[i] = Math.min(dp[i], dp[i - element] + 1);
            }
        }
        return dp[n];
    }

    public int numSquares2(int n) {
        int k = 1;
        TreeSet<Integer> set = new TreeSet<>();
        while (true) {
            if (k * k > n) {
                break;
            }
            set.add(k * k);
            k++;
        }
        int lenMin = Integer.MAX_VALUE;
        for (Integer val : set.descendingSet()) {
            if (n % val == 0) {
                lenMin = Math.min(lenMin, n / val);
                continue;
            }
            int len = recur(val, n, set, lenMin);
            if (len > 0) {
                lenMin = Math.min(len, lenMin);
            }
        }
        return lenMin;
    }

    private int recur(Integer val, Integer sum, TreeSet<Integer> set, int lenMin) {
        int step = sum / val;
        if (step >= lenMin) {
            return -1;
        }
        if (sum % val == 0) {
            return step;
        }
        for (int i = step; i > 0; i--) {
            int sumNext = sum - i * val;
            for (Integer less : set.headSet(val)) {
                int next = recur(less, sumNext, set, lenMin - i);
                if (next > 0) {
                    lenMin = Math.min(lenMin, next + i);
                }
            }
        }
        return lenMin;
    }
}
