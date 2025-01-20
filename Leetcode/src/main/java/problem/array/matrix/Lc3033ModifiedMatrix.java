package problem.array.matrix;

public class Lc3033ModifiedMatrix {

    public int[][] modifiedMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        for (int i = 0; i < cols; i++) {
            int colMax = -1;
            for (int j = 0; j < rows; j++) {
                colMax = Math.max(colMax, matrix[j][i]);
            }
            for (int j = 0; j < rows; j++) {
                if (matrix[j][i] == -1) {
                    matrix[j][i] = colMax;
                }
            }
        }
        return matrix;
    }
}
