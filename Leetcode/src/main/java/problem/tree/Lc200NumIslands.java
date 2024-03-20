package problem.tree;

import java.util.ArrayDeque;
import java.util.Deque;

public class Lc200NumIslands {

    int[] dx = new int[]{0, -1, 1, 0};
    int[] dy = new int[]{1, 0, 0, -1};

    public int numIslands(char[][] grid) {
        int count = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] < '1') {
                    continue;
                }
                Deque<int[]> deque = new ArrayDeque<>();
                deque.offer(new int[]{i, j});
                count++;
                grid[i][j] = 0;
                while (!deque.isEmpty()) {
                    int size = deque.size();
                    for (int k = 0; k < size; k++) {
                        int[] pos = deque.poll();
                        for (int l = 0; l < dx.length; l++) {
                            int x = pos[0] + dx[l];
                            int y = pos[1] + dy[l];
                            if (x < 0 || y < 0 || x >= rows || y >= cols) {
                                continue;
                            }
                            if (grid[x][y] < '1') {
                                continue;
                            }
                            grid[x][y] = 0;
                            deque.offer(new int[]{x, y});
                        }
                    }
                }
            }
        }
        return count;
    }
}
