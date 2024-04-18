package problem.dp.state;

public class Lc2140MostPoints {

    public long mostPoints(int[][] questions) {
        long[] dp = new long[questions.length];
        for (int i = questions.length - 1; i >= 0; i--) {
            dp[i] = i + 1 < questions.length ? dp[i + 1] : 0;
            if (i + 1 + questions[i][1] < questions.length) {
                dp[i] = Math.max(dp[i], dp[i + 1 + questions[i][1]] + questions[i][0]);
            } else {
                dp[i] = Math.max(dp[i], questions[i][0]);
            }
        }
        return dp[0];
    }

    // timeout
    public long mostPoints2(int[][] questions) {
        int[][] dp = new int[questions.length][2];
        int[][] last = new int[questions.length][2];
        int sumMax = 0;
        dp[0][0] = 0;
        dp[0][1] = questions[0][0];
        last[0][0] = 0;
        last[0][1] = questions[0][1];
        sumMax = questions[0][0];
        for (int i = 1; i < questions.length; i++) {
            for (int j = 0; j < i; j++) {
                if (i > last[j][1]) {
                    if (dp[j][1] + questions[i][0] > dp[i][1]) {
                        dp[i][1] = dp[j][1] + questions[i][0];
                        last[i][1] = i + questions[i][1];
                    }
                }
                if (i > last[j][0]) {
                    if (dp[j][0] > dp[i][0]) {
                        dp[i][0] = dp[j][0];
                        last[i][0] = last[j][0];
                    }
                    if (dp[j][0] + questions[i][0] > dp[i][1]) {
                        dp[i][1] = dp[j][0] + questions[i][0];
                        last[i][1] = i + questions[i][1];
                    }
                }
                sumMax = Math.max(sumMax, Math.max(dp[i][0], dp[i][1]));
            }
        }
        return sumMax;
    }
}
