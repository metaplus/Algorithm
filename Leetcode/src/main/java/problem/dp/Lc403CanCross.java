package problem.dp;

public class Lc403CanCross {

    public boolean canCross(int[] stones) {
        if (stones[1] - stones[0] > 1) {
            return false;
        }
        int[][] dp = new int[stones.length][stones.length];
        dp[1][1] = 1;
        for (int i = 2; i < dp.length; i++) {
            for (int j = i - 1; j > 0; j--) {
                int gap = stones[i] - stones[j];
                if (gap > dp.length - 1) {
                    break;
                }
                if (dp[j][gap] > 0) {
                    dp[i][gap]++;
                }
                if (gap - 1 > 0 && dp[j][gap - 1] > 0) {
                    dp[i][gap]++;
                }
                if (gap + 1 < stones.length && dp[j][gap + 1] > 0) {
                    dp[i][gap]++;
                }
            }
        }
        for (int i : dp[stones.length - 1]) {
            if (i > 0) {
                return true;
            }
        }
        return false;
    }
}
