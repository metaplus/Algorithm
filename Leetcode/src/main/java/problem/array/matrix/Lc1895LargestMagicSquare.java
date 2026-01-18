package problem.array.matrix;

public class Lc1895LargestMagicSquare {

    public int largestMagicSquare(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] rowPrefix = new int[row][col];
        int[][] colPrefix = new int[row][col];
        int[][] diagPrefix = new int[row][col];
        int[][] diagReverse = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                rowPrefix[i][j] = grid[i][j] + (j > 0 ? rowPrefix[i][j - 1] : 0);
                colPrefix[i][j] = grid[i][j] + (i > 0 ? colPrefix[i - 1][j] : 0);
                diagPrefix[i][j] = grid[i][j] + (i > 0 && j > 0 ? diagPrefix[i - 1][j - 1] : 0);
                diagReverse[i][j] = grid[i][j] + (i > 0 && j + 1 < col ? diagReverse[i - 1][j + 1] : 0);
            }
        }
        for (int width = Math.min(row, col); width > 1; width--) {
            int rowLast = row - width + 1;
            int colLast = col - width + 1;
            for (int i = 0; i < rowLast; i++) {
                for (int j = 0; j < colLast; j++) {
                    int iLast = i + width - 1;
                    int jLast = j + width - 1;
                    int sum = diagPrefix[iLast][jLast] - (i > 0 && j > 0 ? diagPrefix[i - 1][j - 1] : 0);
                    if (sum == diagReverse[iLast][j] - (i > 0 && jLast + 1 < col ? diagReverse[i - 1][jLast + 1] : 0)) {
                        if (checkSum(i, iLast, j, jLast, sum, rowPrefix, colPrefix)) {
                            return width;
                        }
                    }

                }
            }
        }
        return 1;
    }

    private boolean checkSum(int i, int iLast, int j, int jLast, int sum,
                             int[][] rowPrefix, int[][] colPrefix) {
        for (int k = i; k <= iLast; k++) {
            if (rowPrefix[k][jLast] - (j > 0 ? rowPrefix[k][j - 1] : 0) != sum) {
                return false;
            }
        }
        for (int k = j; k <= jLast; k++) {
            if (colPrefix[iLast][k] - (i > 0 ? colPrefix[i - 1][k] : 0) != sum) {
                return false;
            }
        }
        return true;
    }
}
