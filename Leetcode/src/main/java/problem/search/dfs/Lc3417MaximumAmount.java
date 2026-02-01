package problem.search.dfs;

public class Lc3417MaximumAmount {

    private static final int[][] PATHS = new int[][]{
            new int[]{1, 0},
            new int[]{0, 1},
    };

    private int sumMax = Integer.MIN_VALUE;

    public int maximumAmount(int[][] coins) {
        int row = coins.length;
        int col = coins[0].length;
        dfs(0, 0, 0, row, col,
                coins, new byte[row][col], 2);
        return sumMax;
    }

    private void dfs(int x, int y, int sum,
                     int row, int col,
                     int[][] coins, byte[][] states, int skip) {
        if (x == row - 1 && y == col - 1) {
            if (coins[x][y] >= 0 || skip < 1) {
                sumMax = Math.max(sumMax, sum + coins[x][y]);
            } else {
                sumMax = Math.max(sumMax, sum);
            }
            return;
        }
        states[x][y] = 1;
        dfsPaths(x, y, row, col, coins, states, sum + coins[x][y], skip);
        if (coins[x][y] < 0 && skip > 0) {
            dfsPaths(x, y, row, col, coins, states, sum, skip - 1);
        }
        states[x][y] = 0;
    }

    private void dfsPaths(int x, int y, int row, int col,
                          int[][] coins, byte[][] states,
                          int sumNext, int skipNext) {
        for (int[] path : PATHS) {
            int x2 = x + path[0];
            int y2 = y + path[1];
            if (x2 >= 0 && y2 >= 0
                    && x2 < row && y2 < col
                    && states[x2][y2] == 0) {
                dfs(x2, y2, sumNext, row, col, coins, states, skipNext);
            }
        }
    }
}
