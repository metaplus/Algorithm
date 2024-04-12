package problem.math;

public class Lc172TrailingZeroes {

    public int trailingZeroes(int n) {
        if (n < 5) {
            return 0;
        }
        int[] dp2 = new int[n + 1];
        int[] dp5 = new int[n + 1];
        dp2[2] = 1;
        dp2[4] = 0;
        int sum2 = 3;
        int sum5 = 0;
        for (int i = 5; i <= n; i++) {
            if (i % 2 == 0) {
                dp2[i] = dp2[i / 2] + 1;
            }
            sum2 += dp2[i];
            if (i % 5 == 0) {
                dp5[i] = dp5[i / 5] + 1;
            }
            sum5 += dp5[i];
        }
        return Math.min(sum2, sum5);
    }
}
