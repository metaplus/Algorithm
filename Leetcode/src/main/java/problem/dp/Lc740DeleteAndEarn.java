package problem.dp;

public class Lc740DeleteAndEarn {

    public int deleteAndEarn(int[] nums) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        int[] count = new int[max + 1];
        for (int num : nums) {
            count[num]++;
        }
        int[][] dp = new int[max + 1][2];
        for (int i = 1; i <= max; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = dp[i - 1][0] + count[i] * i;
        }
        return Math.max(dp[max][0], dp[max][1]);
    }
}
