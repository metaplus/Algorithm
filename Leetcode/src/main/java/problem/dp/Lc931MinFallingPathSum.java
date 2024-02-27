package problem.dp;

public class Lc931MinFallingPathSum {
    public int minFallingPathSum(int[][] matrix) {
        int path = Integer.MAX_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i > 0) {
                    if (j == 0) {
                        matrix[i][j] += Math.min(matrix[i - 1][j], matrix[i - 1][j + 1]);
                    } else if (j == matrix[0].length - 1) {
                        matrix[i][j] += Math.min(matrix[i - 1][j], matrix[i - 1][j - 1]);
                    } else {
                        matrix[i][j] += Math.min(matrix[i - 1][j - 1], Math.min(matrix[i - 1][j], matrix[i - 1][j + 1]));
                    }
                }
                if (i == matrix.length - 1 && matrix[i][j] < path) {
                    path = matrix[i][j];
                }
            }
        }
        return path;
    }
}
