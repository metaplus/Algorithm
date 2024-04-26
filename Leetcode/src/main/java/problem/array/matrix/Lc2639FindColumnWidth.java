package problem.array.matrix;

public class Lc2639FindColumnWidth {

    public int[] findColumnWidth(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[] result = new int[cols];
        for (int i = 0; i < cols; i++) {
            int min = grid[0][i];
            int max = grid[0][i];
            for (int j = 1; j < rows; j++) {
                min = Math.min(min, grid[j][i]);
                max = Math.max(max, grid[j][i]);
            }
            result[i] = Math.max(Integer.toString(max).length(), Integer.toString(min).length());
        }
        return result;
    }
}
