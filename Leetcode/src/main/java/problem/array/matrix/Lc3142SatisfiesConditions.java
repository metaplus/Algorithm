package problem.array.matrix;

public class Lc3142SatisfiesConditions {

    public boolean satisfiesConditions(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        for (int i = 1; i < cols; i++) {
            if (grid[0][i] == grid[0][i - 1]) {
                return false;
            }
        }
        for (int i = 0; i < cols; i++) {
            for (int j = 1; j < rows; j++) {
                if (grid[j][i] != grid[j - 1][i]) {
                    return false;
                }
            }
        }
        return true;
    }
}
