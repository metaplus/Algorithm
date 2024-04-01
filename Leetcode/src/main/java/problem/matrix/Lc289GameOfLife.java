package problem.matrix;

public class Lc289GameOfLife {


    public void gameOfLife(int[][] board) {

        int[][] dirs = new int[][]{
                new int[]{-1, 1},
                new int[]{-1, 0},
                new int[]{-1, -1},
                new int[]{1, 1},
                new int[]{1, 0},
                new int[]{1, -1},
                new int[]{0, 1},
                new int[]{0, -1},
        };
        int rows = board.length;
        int cols = board[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 1) {
                    int alive = 0;
                    for (int[] dir : dirs) {
                        int x = i + dir[0];
                        int y = j + dir[1];
                        if (x < 0 || y < 0 || x > rows - 1 || y > cols - 1) {
                            continue;
                        }
                        if ((board[x][y] & 1) == 1) {
                            alive++;
                        }
                    }
                    if (alive >= 2 && alive <= 3) {
                        board[i][j] += 1 << 2;
                    }
                    continue;
                }
                int alive = 0;
                for (int[] dir : dirs) {
                    int x = i + dir[0];
                    int y = j + dir[1];
                    if (x < 0 || y < 0 || x > rows - 1 || y > cols - 1) {
                        continue;
                    }
                    if ((board[x][y] & 1) == 1) {
                        alive++;
                    }
                }
                if (alive == 3) {
                    board[i][j] += (1 << 2);
                }
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                board[i][j] >>= 2;
            }
        }
    }
}
