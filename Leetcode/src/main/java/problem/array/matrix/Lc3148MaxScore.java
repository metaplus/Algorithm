package problem.array.matrix;

import java.util.Arrays;
import java.util.List;

public class Lc3148MaxScore {

    public int maxScore(List<List<Integer>> grid) {
        int rows = grid.size();
        int cols = grid.get(0).size();
        int scoreMax = Integer.MIN_VALUE;
        int[][] dp = new int[rows + 1][cols + 1];
        Arrays.fill(dp[0], Integer.MAX_VALUE);
        for (int i = 1; i < rows + 1; i++) {
            dp[i][0] = Integer.MAX_VALUE;
            List<Integer> row = grid.get(i - 1);
            for (int j = 1; j < cols + 1; j++) {
                dp[i][j] = Math.min(dp[i - 1][j],  dp[i][j - 1]);
                int val = row.get(j - 1);
                scoreMax = Math.max(scoreMax, val - dp[i][j]);
                dp[i][j] = Math.min(dp[i][j], val);
            }
        }
        return scoreMax;
    }

    public int maxScore2(List<List<Integer>> grid) {
        if (grid.isEmpty()) {
            return 0;
        }
        int rows = grid.size();
        int cols = grid.get(0).size();
        int scoreMax = Integer.MIN_VALUE;
        int[][] dp = new int[rows][cols];

        dp[0][0] = 0;
        boolean moved = false;
        int distMax = Integer.MIN_VALUE;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i > 0) {
                    for (int k = 0; k < i; k++) {
                        int val = dp[k][j] + grid.get(i).get(j) - grid.get(k).get(j);
                        if (!moved) {
                            distMax = Math.max(distMax, grid.get(i).get(j) - grid.get(k).get(j));
                        }
                        if (val >= dp[i][j]) {
                            dp[i][j] = val;
                            moved = true;
                        }
                    }
                    scoreMax = Math.max(scoreMax, dp[i][j]);
                }
                if (j > 0) {
                    for (int k = 0; k < j; k++) {
                        int val = dp[i][k] + grid.get(i).get(j) - grid.get(i).get(k);
                        if (!moved) {
                            distMax = Math.max(distMax, grid.get(i).get(j) - grid.get(i).get(k));
                        }
                        if (val >= dp[i][j]) {
                            dp[i][j] = val;
                            moved = true;
                        }
                    }
                    scoreMax = Math.max(scoreMax, dp[i][j]);
                }
            }
        }
        return moved ? scoreMax : distMax;
    }

}
