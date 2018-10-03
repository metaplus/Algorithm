package problem;

import annotation.Problem;

@Problem(
        index = 63,
        solution = UniquePathsII.class,
        description = "A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).\n"
                + "\n"
                + "The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right "
                + "corner of the grid (marked 'Finish' in the diagram below).\n"
                + "\n"
                + "Now consider if some obstacles are added to the grids. How many unique paths would there be?\n"
                + "\n"
                + "\n"
                + "\n"
                + "An obstacle and empty space is marked as 1 and 0 respectively in the grid.\n"
                + "\n"
                + "Note: m and n will be at most 100.\n"
                + "\n"
                + "Example 1:\n"
                + "\n"
                + "Input:\n"
                + "[\n"
                + "  [0,0,0],\n"
                + "  [0,1,0],\n"
                + "  [0,0,0]\n"
                + "]\n"
                + "Output: 2\n"
                + "Explanation:\n"
                + "There is one obstacle in the middle of the 3x3 grid above.\n"
                + "There are two ways to reach the bottom-right corner:\n"
                + "1. Right -> Right -> Down -> Down\n"
                + "2. Down -> Down -> Right -> Right"
)
public class UniquePathsII {

    public int solve(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        int dp[][] = new int[row][col];
        if (obstacleGrid[0][0] == 0) {
            dp[0][0] = 1;
        }
        for (int r = 0; r < row; ++r) {
            for (int c = 0; c < col; ++c) {
                if (obstacleGrid[r][c] == 1) {
                    dp[r][c] = 0;
                } else {
                    if (c >= 1 && obstacleGrid[r][c - 1] == 0) {
                        dp[r][c] += dp[r][c - 1];
                    }
                    if (r >= 1 && obstacleGrid[r - 1][c] == 0) {
                        dp[r][c] += dp[r - 1][c];
                    }
                }
            }

        }
        return dp[row - 1][col - 1];
    }
}
