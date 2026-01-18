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


    public int countNegatives2(int[][] grid) {
        int sum = 0;
        int limit = grid[0].length;
        for (int i = 0; i < grid.length; i++) {
            if (limit == 0) {
                sum += grid[0].length;
                continue;
            }
            int[] row = grid[i];
            int count = binarySearch(row, limit);
            sum += grid[0].length - count;
            limit = count;
        }
        return sum;
    }

    private int binarySearch(int[] row, int limit) {
        if (limit < 2) {
            return row[0] >= 0 ? 1 : 0;
        }
        int left = 0;
        int right = limit - 1;
        int result = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (row[mid] >= 0) {
                result = Math.max(result, mid + 1);
                left = mid + 1;
                continue;
            }
            right = mid - 1;
        }
        return result;
    }
}
