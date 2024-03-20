package problem.tree;

import java.util.ArrayDeque;
import java.util.Deque;

public class Lc934ShortestBridge {


    int[][] adj = new int[][]{
            new int[]{-1, 0},
            new int[]{0, 1},
            new int[]{0, -1},
            new int[]{1, 0},
    };

    public int shortestBridge(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int bridgeMin = Integer.MAX_VALUE;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    bfsIncrement(grid, i, j, rows, cols);
                    i = rows;
                    break;
                }
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    bridgeMin = bfsBridge(grid, i, j, rows, cols, bridgeMin);
                }
            }
        }
        return bridgeMin;
    }

    private int bfsBridge(int[][] grid, int i, int j, int row, int col, int bridgeMin) {
        grid[i][j] = -1;
        Deque<int[]> deque = new ArrayDeque<>();
        deque.offer(new int[]{i, j});
        int level = 0;
        while (!deque.isEmpty()) {
            int size = deque.size();
            level++;
            for (int k = 0; k < size; k++) {
                int[] pos = deque.poll();
                for (int[] next : adj) {
                    int x = pos[0] + next[0];
                    int y = pos[1] + next[1];
                    if (x < 0 || y < 0 || x > row - 1 || y > col - 1) {
                        continue;
                    }
                    if (grid[x][y] == 2) {
                        return Math.min(level - 1, bridgeMin);
                    }
                    if (grid[x][y] < -4) {
                        if (level < -grid[x][y] - 4) {
                            grid[x][y] = -level - 4;
                            deque.offer(new int[]{x, y});
                        }
                        continue;
                    }
                    if (grid[x][y] == 0) {
                        grid[x][y] = -level - 4;
                        deque.offer(new int[]{x, y});
                    }
                }
            }
        }
        return bridgeMin;
    }

    private void bfsIncrement(int[][] grid, int i, int j, int row, int col) {
        grid[i][j] = 2;
        Deque<int[]> deque = new ArrayDeque<>();
        deque.offer(new int[]{i, j});
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int k = 0; k < size; k++) {
                int[] pos = deque.poll();
                for (int[] next : adj) {
                    int x = pos[0] + next[0];
                    int y = pos[1] + next[1];
                    if (x < 0 || y < 0 || x > row - 1 || y > col - 1) {
                        continue;
                    }
                    if (grid[x][y] != 1) {
                        continue;
                    }
                    grid[x][y] = 2;
                    deque.offer(new int[]{x, y});
                }
            }
        }
    }
}
