package problem.dp;

import java.util.Arrays;

public class Lc64MinPathSum {

    public int minPathSum(int[][] grid) {
        int[][] path = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (j > 0 && i > 0) {
                    path[i][j] = Math.min(path[i - 1][j], path[i][j - 1]);
                } else if (j > 0) {
                    path[i][j] = path[i][j - 1];
                } else if (i > 0) {
                    path[i][j] = path[i - 1][j];
                }
                path[i][j] += grid[i][j];
            }
        }
        return path[grid.length - 1][grid[0].length - 1];
    }
}
