package problem.tree;

import java.util.ArrayDeque;
import java.util.Deque;

public class Lc542UpdateMatrix {

    private static final int[][] DIR = new int[][]{
            new int[]{1, 0},
            new int[]{-1, 0},
            new int[]{0, 1},
            new int[]{0, -1}
    };


    public int[][] updateMatrix(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;
        int[][] res = new int[row][col];
        Deque<int[]> deque = new ArrayDeque<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (mat[i][j] == 0) {
                    deque.offer(new int[]{i, j});
                }
            }
        }
        int level = 0;
        while (!deque.isEmpty()) {
            int size = deque.size();
            level++;
            for (int i = 0; i < size; i++) {
                int[] pos = deque.poll();
                for (int[] dir : DIR) {
                    int x = pos[0] + dir[0];
                    int y = pos[1] + dir[1];
                    if (x < 0 || y < 0 || x >= row || y >= col) {
                        continue;
                    }
                    if (mat[x][y] <= 0) {
                        continue;
                    }
                    res[x][y] = level;
                    mat[x][y] *= -1;
                    deque.offer(new int[]{x, y});
                }
            }
        }
        return res;
    }


    //fail
    public int[][] updateMatrix2(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;
        int[][] res = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (mat[i][j] <= 0) {
                    continue;
                }
                dfs(mat, res, i, j, row, col);
            }
        }

        return res;
    }

    private int dfs(int[][] mat, int[][] res, int i, int j, int row, int col) {
        if (i < 0 || j < 0 || i >= row || j >= col) {
            return Integer.MAX_VALUE;
        }
        if (mat[i][j] < 0) {
            return Integer.MAX_VALUE;
        }
        if (mat[i][j] == 0) {
            return 0;
        }
        mat[i][j] *= -1;
        int path = Integer.MAX_VALUE >> 1;
        for (int[] dir : DIR) {
            path = Math.min(path, dfs(mat, res, i + dir[0], j + dir[1], row, col));
        }
        mat[i][j] *= -1;
        return res[i][j] = path + 1;
    }
}
