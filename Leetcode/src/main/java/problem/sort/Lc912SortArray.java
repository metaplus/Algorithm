package problem.sort;

import java.util.Random;

public class Lc912SortArray {

    private final Random random = new Random();

    public int[] sortArray(int[] nums) {
        recursive(nums, 0, nums.length - 1);
        return nums;
    }

    private void recursive(int[] nums, int begin, int end) {
        int index = quickSort(nums, begin, end);
        if (index < 0) {
            return;
        }
        recursive(nums, begin, index - 1);
        recursive(nums, index + 1, end);
    }

    private int quickSort(int[] nums, int begin, int end) {
        if (begin >= end) {
            return -1;
        }
        int pivot = random.nextInt(end - begin + 1) + begin;
        int value = nums[pivot];
        swap(nums, pivot, end);
        int less = 0;
        for (int i = begin; i < end; i++) {
            if (nums[i] <= value) {
                less++;
                swap(nums, i, begin + less - 1);
            }
        }
        swap(nums, end, begin + less);
        return begin + less;
    }

    private void swap(int[] nums, int i, int j) {
        int val = nums[i];
        nums[i] = nums[j];
        nums[j] = val;
    }


    public int[] sortArray2(int[] nums) {
        return shellSort(nums);
    }

    public int[] shellSort(int[] nums) {
        int gap = findGap(nums.length);
        for (int i = gap; i > 0; i = (i - 1) / 3) {
            for (int j = 0; j < i; j++) {
                insertSort(nums, j, i);
            }
        }
        return nums;
    }


    private void insertSort(int[] nums, int start, int gap) {
        for (int i = start + gap; i < nums.length; i += gap) {
            for (int j = i - gap; j >= 0; j -= gap) {
                if (nums[j] <= nums[j + gap]) {
                    break;
                }
                int swap = nums[j];
                nums[j] = nums[j + gap];
                nums[j + gap] = swap;
            }
        }
    }

    private static int findGap(int len) {
        int gap = 1;
        while (3 * gap + 1 < len) {
            gap = 3 * gap + 1;
        }
        return gap;
    }
}
