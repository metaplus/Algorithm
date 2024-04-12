package problem.dp;

public class Lc1964LongestObstacleCourseAtEachPosition {

    // tle
    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        int[] dp = new int[obstacles.length];
        dp[0] = 1;
        for (int i = 1; i < obstacles.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (obstacles[i] >= obstacles[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        return dp;
    }
}
