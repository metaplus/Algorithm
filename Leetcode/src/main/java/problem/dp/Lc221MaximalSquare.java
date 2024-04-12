package problem.dp;

import java.util.ArrayDeque;
import java.util.Deque;

public class Lc221MaximalSquare {

    public int maximalSquare(char[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] dp = new int[rows][cols];
        int sideMax = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                        sideMax = Math.max(sideMax, 1);
                        continue;
                    }
                    int side = Math.min(dp[i - 1][j], dp[i][j - 1]);
                    side = Math.min(side, dp[i - 1][j - 1]);
                    dp[i][j] = 1 + side;
                    sideMax = Math.max(sideMax, dp[i][j]);
                }
            }
        }
        return sideMax * sideMax;
    }

    // fail
    public int maximalSquare2(char[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] left = new int[rows];
        Deque<Integer> height = new ArrayDeque<>();
        int areaMax = 0;
        for (int j = 0; j < cols; j++) {
            height.clear();
            int zero = -1;
            for (int i = 0; i < rows; i++) {
                if (matrix[i][j] == '0') {
                    zero = i;
                    left[i] = 0;
                    height.clear();
                    continue;
                }
                if (matrix[i][j] == '1') {
                    left[i]++;
                    while (!height.isEmpty() && left[height.peek()] >= left[i]) {
                        int y = i - height.peek() + 1;
//                        int x = Math.min(y, left[height.peek()]);
                        int x = Math.min(y, left[i]);
                        int area = x * x;
                        areaMax = Math.max(areaMax, area);
                        height.pop();
                    }
                    int y = height.isEmpty() ? i - zero : i - height.peek();
                    int x = Math.min(y, left[i]);
                    int area = x * x;
                    areaMax = Math.max(areaMax, area);
                    if (!height.isEmpty()) {
                        y = i - height.peek() + 1;
                        x = Math.min(y, left[i]);
                        x = Math.min(x, left[height.peek()]);
                        area = x * x;
                        areaMax = Math.max(areaMax, area);
                    }
//                    if (height.isEmpty() || left[height.peek()] > left[i]) {
//                    }
                    height.push(i);
                }
            }
        }
        return areaMax;
    }
}
