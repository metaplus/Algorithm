package problem.tree;

import java.util.ArrayDeque;
import java.util.Deque;

public class Lc695maxAreaOfIsland {

    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] <= 0) {
                    continue;
                }
                int area = sumArea(grid, i, j, grid.length, grid[i].length);
                maxArea = Math.max(area, maxArea);
            }
        }
        return maxArea;
    }

    private int sumArea(int[][] grid, int i, int j, int width, int height) {
        Deque<int[]> deque = new ArrayDeque<>();
        int area = 0;
        deque.offer(new int[]{i, j});
        while (!deque.isEmpty()) {
            int size = deque.size();
            area += size;
            for (int k = 0; k < size; k++) {
                int[] pos = deque.poll();
                int x = pos[0];
                int y = pos[1];
                grid[x][y] = -1;
                if (x + 1 < width && grid[x + 1][y] > 0) {
                    deque.add(new int[]{x + 1, y});
                    grid[x + 1][y] = -1;
                }
                if (x - 1 >= 0 && grid[x - 1][y] > 0) {
                    deque.add(new int[]{x - 1, y});
                    grid[x - 1][y] = -1;
                }
                if (y + 1 < height && grid[x][y + 1] > 0) {
                    deque.add(new int[]{x, y + 1});
                    grid[x][y + 1] = -1;
                }
                if (y - 1 >= 0 && grid[x][y - 1] > 0) {
                    deque.add(new int[]{x, y - 1});
                    grid[x][y - 1] = -1;
                }
            }
        }
        return area;
    }
}
