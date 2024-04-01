package problem.array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Lc2580CountWays {

    private static final long MOD = 1000000000 + 7;

    public int countWays(int[][] ranges) {
        Arrays.sort(ranges, Comparator.comparingInt(arr -> arr[0]));
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        int area = 0;
        for (int i = 0; i < ranges.length; i++) {
            if (queue.isEmpty()) {
                queue.add(ranges[i][1]);
                continue;
            }
            if (queue.peek() < ranges[i][0]) {
                area++;
                queue.clear();
                queue.offer(ranges[i][1]);
                continue;
            }
            if (ranges[i][1] > queue.peek()) {
                queue.offer(ranges[i][1]);
            }
        }
        if (!queue.isEmpty()) {
            area++;
        }
        long pow = fastPow(2, area);
        return (int) (pow % MOD);
    }

    private long fastPow(int x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        long half = fastPow(x, n / 2);
        half %= MOD;
        if (n % 2 == 1) {
            return half * half * x;
        }
        return half * half;
    }

}

