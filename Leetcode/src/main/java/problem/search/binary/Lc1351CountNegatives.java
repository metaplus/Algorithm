package problem.search.binary;

public class Lc1351CountNegatives {

    public int countNegatives(int[][] grid) {
        int last = grid[0].length;
        int sum = 0;
        for (int i = 0; i < grid.length; i++) {
            int left = 0;
            int right = last;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (grid[i][mid] >= 0) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            sum += grid[0].length - left;
            last = left;
        }
        return sum;
    }
}
