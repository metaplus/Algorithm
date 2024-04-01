package problem.math;

public class Lc204CountPrimes {

    public int countPrimes(int n) {
        if (n <= 2) {
            return 0;
        }
        boolean[] dp = new boolean[n + 1];
        int count = 1;
        dp[2] = true;
        for (int i = 3; i < n; i++) {
            boolean prime = true;
            for (int j = 2; j < i; j++) {
                if (dp[j]) {
                    if (i % j == 0) {
                        prime = false;
                        break;
                    }
                }
            }
            if (prime) {
                dp[i] = true;
                count++;
            }
        }
        return count;
    }
}
