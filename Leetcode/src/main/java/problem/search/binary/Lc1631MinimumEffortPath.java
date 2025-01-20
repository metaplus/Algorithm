package problem.search.binary;

public class Lc1631MinimumEffortPath {




    // timeout
    public int minimumEffortPath(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;
        if (rows == 1 && cols == 1) {
            return 0;
        }
        int left = 0;
        int right = Integer.MAX_VALUE >> 8;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (!dfs(heights, 0, 0, rows, cols, 0, mid)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public boolean dfs(int[][] heights, int i, int j, int rows, int cols, int prev, int weightMax) {
        if (i < 0 || j < 0 || i >= rows || j >= cols) {
            return false;
        }
        if (heights[i][j] < 0) {
            return false;
        }
        int diff = Math.abs(heights[i][j] - prev);
        if ((i != 0 || j != 0) && diff > weightMax) {
            return false;
        }
        if (i == rows - 1 && j == cols - 1) {
            return true;
        }
        int h = heights[i][j];
        heights[i][j] *= -1;
        boolean result = dfs(heights, i + 1, j, rows, cols, h, weightMax)
                || dfs(heights, i - 1, j, rows, cols, h, weightMax)
                || dfs(heights, i, j + 1, rows, cols, h, weightMax)
                || dfs(heights, i, j - 1, rows, cols, h, weightMax);
        heights[i][j] *= -1;
        return result;
    }

    private int diffMax = Integer.MAX_VALUE;

    // timeout
    public int minimumEffortPath2(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;
        if (rows == 1 && cols == 1) {
            return 0;
        }
        dfs2(heights, 0, 0, rows, cols, 0, 0);
        return diffMax;
    }

    public int dfs2(int[][] heights, int i, int j, int rows, int cols, int prev, int prefixMax) {
        if (i < 0 || j < 0 || i >= rows || j >= cols) {
            return 0;
        }
        if (heights[i][j] < 0) {
            return 0;
        }
        int diff = i != 0 || j != 0 ? Math.abs(prev - heights[i][j]) : 0;
        if (i == rows - 1 && j == cols - 1) {
            diffMax = Math.min(Math.max(prefixMax, diff), diffMax);
            return diff;
        }
        if (diff >= diffMax) {
            return 0;
        }
        heights[i][j] *= -1;
        int result = diff;
        result = Math.max(result, dfs2(heights, i - 1, j, rows, cols, -heights[i][j], Math.max(prefixMax, diff)));
        result = Math.max(result, dfs2(heights, i, j - 1, rows, cols, -heights[i][j], Math.max(prefixMax, diff)));
        result = Math.max(result, dfs2(heights, i + 1, j, rows, cols, -heights[i][j], Math.max(prefixMax, diff)));
        result = Math.max(result, dfs2(heights, i, j + 1, rows, cols, -heights[i][j], Math.max(prefixMax, diff)));
        heights[i][j] *= -1;
        return result;
    }
}
