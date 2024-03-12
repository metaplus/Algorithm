package problem.array;

public class Lc977SortedSquares {

    public int[] sortedSquares(int[] nums) {
        int mid = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                continue;
            }
            mid = i;
            break;
        }
        if (mid < 0) {
            for (int i = 0; i < nums.length / 2; i++) {
                swap(nums, i, nums.length - 1 - i);
            }
            for (int i = 0; i < nums.length; i++) {
                nums[i] *= nums[i];
            }
            return nums;
        }
        if (mid == 0) {
            for (int i = 0; i < nums.length; i++) {
                nums[i] *= nums[i];
            }
            return nums;
        }
        int[] sort = new int[nums.length];
        int left = mid - 1;
        int right = mid;
        int id = 0;
        while (left >= 0 && right < nums.length) {
            if (-nums[left] < nums[right]) {
                sort[id++] = nums[left--];
                continue;
            }
            sort[id++] = nums[right++];
        }
        if (left >= 0) {
            for (int i = left; i >= 0; i--) {
                sort[id++] = nums[i];
            }
        }
        if (right < nums.length) {
            for (int i = right; i < nums.length; i++) {
                sort[id++] = nums[i];
            }
        }
        for (int i = 0; i < sort.length; i++) {
            sort[i] *= sort[i];
        }
        return sort;
    }

    private void swap(int[] arr, int i, int j) {
        if (i != j) {
            int val = arr[i];
            arr[i] = arr[j];
            arr[j] = val;
        }
    }
}
