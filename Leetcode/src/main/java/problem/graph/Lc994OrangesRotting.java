package problem.graph;

import java.util.ArrayDeque;
import java.util.Deque;

public class Lc994OrangesRotting {

    private static final int[][] DIRS = new int[][]{
            new int[]{1, 0},
            new int[]{-1, 0},
            new int[]{0, -1},
            new int[]{0, 1}};

    public int orangesRotting(int[][] grid) {
        Deque<int[]> deque = new ArrayDeque<>();
        int rows = grid.length;
        int cols = grid[0].length;
        int orange = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    deque.offer(new int[]{i, j});
                }
                if (grid[i][j] == 1) {
                    orange++;
                }
            }
        }
        if (orange == 0) {
            return 0;
        }
        int level = 0;
        int count = 0;
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
                    if (grid[x][y] != 1) {
                        continue;
                    }
                    grid[x][y] = 2;
                    count++;
                    deque.offer(new int[]{x, y});
                }
            }
        }
        if (count != orange) {
            return -1;
        }
        return level - 1;
    }
}
