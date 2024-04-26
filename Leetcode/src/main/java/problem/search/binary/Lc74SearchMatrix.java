package problem.search.binary;

public class Lc74SearchMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        if (target < matrix[0][0] || target > matrix[rows - 1][cols - 1]) {
            return false;
        }
        int left = 0;
        int right = rows;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (matrix[mid][0] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        int rowSearch = left - 1;
        left = 0;
        right = cols;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (matrix[rowSearch][mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left < cols && target == matrix[rowSearch][left];
    }

    public boolean searchMatrix3(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int left = 0;
        int right = rows - 1;
        while (left < right) {
            int mid = (left + right + 1) / 2;
            if (matrix[mid][0] > target) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        for (int i = 0; i < cols; i++) {
            if (matrix[left][i] == target) {
                return true;
            }
        }
        return false;
    }

    public boolean searchMatrix2(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int i = 0;
        int j = cols - 1;
        while (i < rows && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            }
            if (matrix[i][j] < target) {
                i++;
                continue;
            }
            j--;
        }
        return false;
    }
}
