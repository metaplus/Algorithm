package problem.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Lc417PacificAtlantic {

    private int[] dx = new int[]{-1, 0, 0, 1};
    private int[] dy = new int[]{0, 1, -1, 0};


    private void markVisit(int[][] heights, int i, int j,
                           int rows, int cols) {
        if (heights[i][j] < 0) {
            return;
        }
        heights[i][j] *= -1;
        Deque<int[]> deque = new ArrayDeque<>();
        deque.offer(new int[]{i, j});
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
                    if (heights[x][y] < 0
                            || heights[x][y] < Math.abs(heights[pos[0]][pos[1]])) {
                        continue;
                    }
                    heights[x][y] *= -1;
                    deque.add(new int[]{x, y});
                }
            }
        }
    }

    private void findVisit(int[][] heights, int i, int j,
                           int rows, int cols, boolean[] visit,
                           List<List<Integer>> result) {
        int id = i * cols + j;
        if (visit[id]) {
            return;
        }
        if (heights[i][j] < 0) {
            visit[id] = true;
            List<Integer> next = new ArrayList<>(2);
            next.add(i);
            next.add(j);
            result.add(next);
        }
        Deque<int[]> deque = new ArrayDeque<>();
        deque.offer(new int[]{i, j});
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
                    id = x * cols + y;
                    if (visit[id]) {
                        continue;
                    }
                    if (Math.abs(heights[x][y]) < Math.abs(heights[pos[0]][pos[1]])) {
                        continue;
                    }
                    visit[id] = true;
                    if (heights[x][y] < 0) {
                        List<Integer> next = new ArrayList<>(2);
                        next.add(x);
                        next.add(y);
                        result.add(next);
                    }
                    deque.add(new int[]{x, y});
                }
            }
        }
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                heights[i][j]++;
            }
        }
        for (int i = 0; i < rows; i++) {
            markVisit(heights, i, 0, rows, cols);
        }
        for (int i = 0; i < cols; i++) {
            markVisit(heights, 0, i, rows, cols);
        }
        boolean[] visit = new boolean[rows * cols];
        for (int i = 0; i < rows; i++) {
            findVisit(heights, i, cols - 1, rows, cols, visit, result);
        }
        for (int i = 0; i < cols - 1; i++) {
            findVisit(heights, rows - 1, i, rows, cols, visit, result);
        }
        return result;
    }

}
