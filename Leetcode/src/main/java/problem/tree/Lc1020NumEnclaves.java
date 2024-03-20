package problem.tree;

public class Lc1020NumEnclaves {

    private int[][] dirs = new int[][]{
            new int[]{-1, 0},
            new int[]{1, 0},
            new int[]{0, -1},
            new int[]{0, 1},
    };

    public int numEnclaves(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        for (int i = 0; i < rows; i++) {
            if (grid[i][0] == 1) {
                dfsMark(grid, i, 0, rows, cols);
            }
            if (grid[i][cols - 1] == 1) {
                dfsMark(grid, i, cols - 1, rows, cols);
            }
        }
        for (int i = 0; i < cols; i++) {
            if (grid[0][i] == 1) {
                dfsMark(grid, 0, i, rows, cols);
            }
            if (grid[rows - 1][i] == 1) {
                dfsMark(grid, rows - 1, i, rows, cols);
            }
        }
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    count++;
                }
            }
        }
        return count;
    }

    void dfsMark(int[][] grid, int i, int j, int rows, int cols) {
        if (i < 0 || j < 0 || i > rows - 1 || j > cols - 1) {
            return;
        }
        if (grid[i][j] != 1) {
            return;
        }
        grid[i][j] = -1;
        dfsMark(grid, i - 1, j, rows, cols);
        dfsMark(grid, i + 1, j, rows, cols);
        dfsMark(grid, i, j + 1, rows, cols);
        dfsMark(grid, i, j - 1, rows, cols);
    }
}
