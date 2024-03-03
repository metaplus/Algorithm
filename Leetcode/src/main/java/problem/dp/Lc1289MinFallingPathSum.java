package problem.dp;

public class Lc1289MinFallingPathSum {

    public int minFallingPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] path = new int[m][n];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0) {
                    path[0][j] = grid[0][j];
                } else {
                    path[i][j] = grid[i][j] + findMinPath(path[i - 1], j);
                }
                if (i == m - 1) {
                    min = Math.min(min, path[i][j]);
                }
            }
        }
        return min;
    }


    private int findMinPath(int[] row, int exclude) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < row.length; i++) {
            if (i == exclude) {
                continue;
            }
            min = Math.min(min, row[i]);
        }
        return min;
    }
}
