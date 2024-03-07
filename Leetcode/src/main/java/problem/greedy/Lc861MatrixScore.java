package problem.greedy;

public class Lc861MatrixScore {

    public int matrixScore(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        for (int i = 0; i < row; i++) {
            if (grid[i][0] > 0) {
                continue;
            }
            for (int j = 0; j < col; j++) {
                grid[i][j] = 1 - grid[i][j];
            }
        }
        for (int j = 1; j < col; j++) {
            int count = 0;
            for (int i = 0; i < row; i++) {
                if (grid[i][j] > 0) {
                    count++;
                }
            }
            if (count > row / 2) {
                continue;
            }
            for (int i = 0; i < row; i++) {
                grid[i][j] = 1 - grid[i][j];
            }
        }
        int sum = 0;
        for (int j = col - 1, base = 1; j >= 0; j--, base *= 2) {
            for (int i = 0; i < row; i++) {
                if (grid[i][j] > 0) {
                    sum += base;
                }
            }
        }
        return sum;
    }
}
