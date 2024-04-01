package problem.tree;

import java.util.ArrayDeque;
import java.util.Deque;

public class Lc1034ColorBorder {

    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        int rows = grid.length;
        int cols = grid[0].length;
        int c = grid[row][col];
        bfs(grid, row, col, rows, cols, c, color);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == Integer.MIN_VALUE) {
                    grid[i][j] = color;
                }
                if (grid[i][j] < 0) {
                    grid[i][j] *= -1;
                }
            }
        }
        return grid;
    }


    private void bfs(int[][] grid, int i, int j, int rows, int cols, int c, int color) {
        int[][] dirs = new int[][]{
                new int[]{1, 0},
                new int[]{-1, 0},
                new int[]{0, 1},
                new int[]{0, -1}
        };
        Deque<int[]> deque = new ArrayDeque<>();
        deque.offer(new int[]{i, j});
        if (i == 0 || j == 0 || i == rows - 1 || j == cols - 1) {
            grid[i][j] = Integer.MIN_VALUE;
        } else {
            grid[i][j] *= -1;
        }
        while (!deque.isEmpty()) {
            int size = deque.size();
            while (size-- > 0) {
                int[] pos = deque.poll();
                for (int[] dir : dirs) {
                    int x = pos[0] + dir[0];
                    int y = pos[1] + dir[1];
                    if (x < 0 || y < 0 || x > rows - 1 || y > cols - 1) {
                        grid[pos[0]][pos[1]] = Integer.MIN_VALUE;
                        continue;
                    }
                    if (grid[x][y] != Integer.MIN_VALUE && Math.abs(grid[x][y]) != c) {
                        if (grid[x][y] > 0) {
                            grid[x][y] *= -1;
                        }
                        grid[pos[0]][pos[1]] = Integer.MIN_VALUE;
                        continue;
                    }
                    if (grid[x][y] > 0) {
                        deque.offer(new int[]{x, y});
                        grid[x][y] *= -1;
                    }
                }
            }
        }
    }
}
