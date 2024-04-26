package problem.array.matrix;

import java.util.Arrays;

public class Lc1329DiagonalSort {

    public int[][] diagonalSort(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        for (int i = 0; i < rows; i++) {
            int[] sort = new int[Math.min(rows, cols)];
            Arrays.fill(sort, Integer.MAX_VALUE);
            for (int j = 0; j < cols && i + j < rows; j++) {
                sort[j] = mat[i + j][j];
            }
            Arrays.sort(sort);
            for (int j = 0; j < cols && i + j < rows; j++) {
                mat[i + j][j] = sort[j];
            }
        }
        for (int i = 1; i < cols; i++) {
            int[] sort = new int[Math.min(rows, cols)];
            Arrays.fill(sort, Integer.MAX_VALUE);
            for (int j = 0; j < rows && i + j < cols; j++) {
                sort[j] = mat[j][i + j];
            }
            Arrays.sort(sort);
            for (int j = 0; j < rows && i + j < cols; j++) {
                mat[j][i + j] = sort[j];
            }
        }
        return mat;
    }
}
