package problem.array.matrix;

public class Lc48Rotate {

    public void rotate(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j <= i ; j++) {
                swap(matrix, i, j, j, i);
            }
        }
        int x = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols / 2; j++) {
                swap(matrix, i, j, i, cols - 1 - j);
            }
        }
    }

    private void swap(int[][] matrix, int i, int j, int x, int y) {
        if (i == x && j == y) {
            return;
        }
        int val = matrix[i][j];
        matrix[i][j] = matrix[x][y];
        matrix[x][y] = val;
    }
}
