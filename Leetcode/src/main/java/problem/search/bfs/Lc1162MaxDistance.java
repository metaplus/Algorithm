package problem.search.bfs;

import java.util.ArrayDeque;
import java.util.Deque;

public class Lc1162MaxDistance {

    private static final int[][] DIRS = new int[][]{
            new int[]{1, 0},
            new int[]{-1, 0},
            new int[]{0, 1},
            new int[]{0, -1},
    };

    public int maxDistance(int[][] grid) {
        int distMax = 0;
        Deque<int[]> deque = new ArrayDeque<>();
        int rows = grid.length;
        int cols = grid[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    deque.addLast(new int[]{i, j});
                }
            }
        }
        int level = 0;
        while (!deque.isEmpty()) {
            int size = deque.size();
            level++;
            while (size-- > 0) {
                int[] pos = deque.poll();
                for (int[] dir : DIRS) {
                    int x = pos[0] + dir[0];
                    int y = pos[1] + dir[1];
                    if (x < 0 || y < 0 || x >= rows || y >= cols) {
                        continue;
                    }
                    if (grid[x][y] != 0) {
                        continue;
                    }
                    grid[x][y] = -level;
                    distMax = Math.max(distMax, level);
                    deque.addLast(new int[]{x, y});
                }
            }
        }
        return distMax > 0 ? distMax : -1;
    }
}
