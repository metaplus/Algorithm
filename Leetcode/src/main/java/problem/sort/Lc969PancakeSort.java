package problem.sort;

import java.util.ArrayList;
import java.util.List;

public class Lc969PancakeSort {

    public List<Integer> pancakeSort(int[] arr) {
        int[] counts = countSort(arr);
        int min = counts[counts.length - 2];
        int max = counts[counts.length - 1];
        int tail = max;
        List<Integer> ops = new ArrayList<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            int start = arr[i] - min > 0 ? counts[arr[i] - min - 1] : 0;
            if (start <= i && i < counts[arr[i] - min]) {
                continue;
            }
            for (int j = tail; j >= min; j--) {
                if (j == min) {
                    tail = min;
                    continue;
                }
                if (i >= counts[j - min - 1] && i < counts[j - min]) {
                    tail = j;
                    break;
                }
            }
            for (int j = 0; j < i; j++) {
                if (arr[j] == tail) {
                    if (j > 0) {
                        ops.add(j + 1);
                    }
                    ops.add(i + 1);
                    pancakeSwap(arr, j + 1);
                    pancakeSwap(arr, i + 1);
                    break;
                }
            }
        }
        return ops;
    }

    private static int[] countSort(int[] nums) {
        int min = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }
        int[] count = new int[max - min + 3];
        for (int num : nums) {
            count[num - min]++;
        }
        for (int i = 1; i < max - min + 1; i++) {
            count[i] += count[i - 1];
        }
        count[count.length - 2] = min;
        count[count.length - 1] = max;
        return count;
    }

    private static void pancakeSwap(int[] nums, int len) {
        if (len < 2) {
            return;
        }
        for (int i = len / 2; i < len; i++) {
            int val = nums[i];
            nums[i] = nums[len - 1 - i];
            nums[len - 1 - i] = val;
        }
    }
}
