package problem.matrix;

import java.util.HashSet;
import java.util.Set;

public class Lc73SetZeroes {

    public void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        Set<Integer> zeroX = new HashSet<>();
        Set<Integer> zeroY = new HashSet<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    zeroX.add(i);
                    zeroY.add(j);
                }
            }
        }
        for (Integer x : zeroX) {
            for (int i = 0; i < cols; i++) {
                matrix[x][i] = 0;
            }
        }
        for (Integer y : zeroY) {
            for (int i = 0; i < rows; i++) {
                matrix[i][y] = 0;
            }
        }
    }
}
