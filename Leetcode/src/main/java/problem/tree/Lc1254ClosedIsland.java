package problem.tree;

public class Lc1254ClosedIsland {


    public int closedIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        for (int i = 0; i < rows; i++) {
            dfsIslandEdge(grid, i, 0, rows, cols);
            dfsIslandEdge(grid, i, cols - 1, rows, cols);
        }
        for (int i = 0; i < cols; i++) {
            dfsIslandEdge(grid, 0, i, rows, cols);
            dfsIslandEdge(grid, rows - 1, i, rows, cols);
        }
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 0) {
                    count++;
                    dfsIslandInternal(grid, i, j, rows, cols);
                }
            }
        }
        return count;
    }


    private void dfsIslandInternal(int[][] grid, int i, int j, int rows, int cols) {
        if (i < 0 || j < 0 || i > rows - 1 || j > cols - 1) {
            return;
        }
        if (grid[i][j] != 0) {
            return;
        }
        grid[i][j] = -1;
        dfsIslandInternal(grid, i - 1, j, rows, cols);
        dfsIslandInternal(grid, i + 1, j, rows, cols);
        dfsIslandInternal(grid, i, j + 1, rows, cols);
        dfsIslandInternal(grid, i, j - 1, rows, cols);
    }

    private void dfsIslandEdge(int[][] grid, int i, int j, int rows, int cols) {
        if (i < 0 || j < 0 || i > rows - 1 || j > cols - 1) {
            return;
        }
        if (grid[i][j] != 0) {
            return;
        }
        grid[i][j] = 2;
        dfsIslandEdge(grid, i - 1, j, rows, cols);
        dfsIslandEdge(grid, i + 1, j, rows, cols);
        dfsIslandEdge(grid, i, j + 1, rows, cols);
        dfsIslandEdge(grid, i, j - 1, rows, cols);
    }
}
