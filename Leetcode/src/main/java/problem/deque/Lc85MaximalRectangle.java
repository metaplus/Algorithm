package problem.deque;

import java.util.ArrayDeque;
import java.util.Deque;

public class Lc85MaximalRectangle {

    public int maximalRectangle(char[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] left = new int[row][col];
        for (int i = 0; i < row; i++) {
            left[i][0] = matrix[i][0] == '1' ? 1 : 0;
            for (int j = 1; j < col; j++) {
                left[i][j] = matrix[i][j] == '1' ? left[i][j - 1] + 1 : 0;
            }
        }
        int areaMax = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == '0') {
                    continue;
                }
                int area = left[i][j];
                int leftMin = left[i][j];
                for (int k = i - 1; k >= 0; k--) {
                    if (matrix[k][j] == '0') {
                        break;
                    }
                    leftMin = Math.min(leftMin, left[k][j]);
                    area = Math.max(area, leftMin * (i - k + 1));
                }
                areaMax = Math.max(areaMax, area);
            }
        }
        return areaMax;
    }

    public int maximalRectangle2(char[][] matrix) {
        int m = matrix.length;
        if (m == 0) {
            return 0;
        }
        int n = matrix[0].length;
        int[][] left = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    left[i][j] = (j == 0 ? 0 : left[i][j - 1]) + 1;
                }
            }
        }
        int ret = 0;
        for (int j = 0; j < n; j++) { // 对于每一列，使用基于柱状图的方法
            int[] up = new int[m];
            int[] down = new int[m];
            Deque<Integer> stack = new ArrayDeque<>();
            for (int i = 0; i < m; i++) {
                while (!stack.isEmpty() && left[stack.peek()][j] >= left[i][j]) {
                    stack.pop();
                }
                up[i] = stack.isEmpty() ? -1 : stack.peek();
                stack.push(i);
            }
            stack.clear();
            for (int i = m - 1; i >= 0; i--) {
                while (!stack.isEmpty() && left[stack.peek()][j] >= left[i][j]) {
                    stack.pop();
                }
                down[i] = stack.isEmpty() ? m : stack.peek();
                stack.push(i);
            }
            for (int i = 0; i < m; i++) {
                int height = down[i] - up[i] - 1;
                int area = height * left[i][j];
                ret = Math.max(ret, area);
            }
        }
        return ret;
    }

}
