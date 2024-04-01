package problem.dp;

import java.util.TreeSet;

public class Lc279NumSquares {

    public int numSquares(int n) {
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
