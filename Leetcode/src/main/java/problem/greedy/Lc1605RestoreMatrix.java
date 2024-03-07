package problem.greedy;

import java.util.Arrays;

public class Lc1605RestoreMatrix {

    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        if (colSum.length == 1) {
            int[][] matrix = new int[rowSum.length][1];
            for (int i = 0; i < rowSum.length; i++) {
                matrix[i][0] = rowSum[i];
            }
            return matrix;
        }
        if (rowSum.length == 1) {
            int[][] matrix = new int[1][colSum.length];
            for (int i = 0; i < colSum.length; i++) {
                matrix[0][i] = colSum[i];
            }
            return matrix;
        }
        int[][] matrix = new int[rowSum.length][colSum.length];
        int[] rowIndices = radixSort(rowSum, new int[rowSum.length]);
        for (int rowIndex : rowIndices) {
            int[] colIndices = radixSort(colSum, new int[colSum.length]);
            for (int colIndex : colIndices) {
                int cost = Math.min(colSum[colIndex], rowSum[rowIndex]);
                matrix[rowIndex][colIndex] = cost;
                colSum[colIndex] -= cost;
                rowSum[rowIndex] -= cost;
                if (rowSum[rowIndex] == 0) {
                    break;
                }
            }
        }
        return matrix;
    }

    private int[] radixSort(int[] nums, int[] indices) {
        int max = nums[0];
        for (int num : nums) {
            max = Math.max(max, num);
        }
        for (int i = 0; i < nums.length; i++) {
            indices[i] = i;
        }
        int digit = 0;
        for (int i = max; i > 0; i /= 10) {
            digit++;
        }
        int[] count = new int[10];
        int[] sort = new int[indices.length];
        int div = 1;
        for (int i = 0; i < digit; i++) {
            for (int index : indices) {
                count[(nums[index] / div) % 10]++;
            }
            for (int j = 1; j < count.length; j++) {
                count[j] += count[j - 1];
            }
            for (int j = indices.length - 1; j >= 0; j--) {
                sort[--count[(nums[indices[j]] / div) % 10]] = indices[j];
            }
            Arrays.fill(count, 0);
            System.arraycopy(sort, 0, indices, 0, indices.length);
            div *= 10;
        }
        return indices;
    }
}
