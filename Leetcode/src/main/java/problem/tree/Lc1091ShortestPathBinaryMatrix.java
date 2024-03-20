package problem.tree;

import java.util.ArrayDeque;
import java.util.Deque;

public class Lc1091ShortestPathBinaryMatrix {

    int[] nextX = new int[]{-1, 0, 1, -1, 1, -1, 0, 1};
    int[] nextY = new int[]{1, 1, 1, 0, 0, -1, -1, -1};

    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] > 0 || grid[grid.length - 1][grid[0].length - 1] > 0) {
            return -1;
        }
        Deque<int[]> deque = new ArrayDeque<>();
        int level = 0;
        deque.offer(new int[]{0, 0});
        while (!deque.isEmpty()) {
            int size = deque.size();
            level++;
            for (int i = 0; i < size; i++) {
                int[] pos = deque.poll();
                int x = pos[0];
                int y = pos[1];
                if (x == grid.length - 1 && y == grid[0].length - 1) {
                    return level;
                }
                grid[x][y] = -level;
                for (int j = 0; j < nextX.length; j++) {
                    int x1 = x + nextX[j];
                    int y1 = y + nextY[j];
                    if (x1 < 0 || x1 > grid.length - 1 || y1 < 0 || y1 > grid[0].length - 1) {
                        continue;
                    }
                    if (grid[x1][y1] != 0) {
                        continue;
                    }
                    grid[x1][y1] = -level - 1;
                    deque.offer(new int[]{x1, y1});
                }
            }
        }
        return -1;
    }
}
