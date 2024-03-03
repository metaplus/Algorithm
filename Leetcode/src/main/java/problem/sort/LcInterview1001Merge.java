package problem.sort;

import java.util.Arrays;

public class LcInterview1001Merge {

    public void merge(int[] A, int m, int[] B, int n) {
        if (n == 0) {
            int[] result = new int[m];
            mergeSort(A, 0, m - 1, result, 0);
            System.arraycopy(result, 0, A, 0, m);
            return;
        }
        mergeSort(B, 0, n - 1, A, m);
        int[] result = new int[m + n];
        mergeSort(A, 0, m + n - 1, result, 0);
    }

    private void mergeSort(int[] nums, int start, int end, int[] result, int offset) {
        if (start > end) {
            return;
        }
        if (start == end) {
            result[start + offset] = nums[start];
            return;
        }
        int middle = (start + end) / 2;
        mergeSort(nums, start, middle, result, offset);
        mergeSort(nums, middle + 1, end, result, offset);
        int index1 = start;
        int index2 = middle + 1;
        while (index1 <= middle && index2 <= end) {
            if (nums[index1] < nums[index2]) {
                result[index1 + index2 - middle - 1 + offset] = nums[index1];
                index1++;
                continue;
            }
            result[index1 + index2 - middle - 1 + offset] = nums[index2];
            index2++;
        }
        while (index1 <= middle) {
            result[index1 + index2 - middle - 1 + offset] = nums[index1];
            index1++;
        }
        while (index2 <= end) {
            result[index1 + index2 - middle - 1 + offset] = nums[index2];
            index2++;
        }
        System.arraycopy(result, start + offset, nums, start, end - start + 1);
    }
}
