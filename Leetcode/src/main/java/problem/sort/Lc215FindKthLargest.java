package problem.sort;

public class Lc215FindKthLargest {

    public int findKthLargestExample(int[] nums, int k) {
        int[] count = new int[20001];
        for (int i = 0; i < nums.length; i++)
            count[nums[i] + 10000]++;
        for (int i = 20000; i >= 0; i--) {
            k -= count[i];
            if (k <= 0)
                return i - 10000;
        }
        return 0;
    }

    public int findKthLargest(int[] nums, int k) {
        if (k < nums.length / 2) {
            for (int i = 0; i < k; i++) {
                for (int j = (nums.length - i) / 2 - 1; j >= 0; j--) {
                    heapSortMax(nums, j, nums.length - i);
                }
                swap(nums, 0, nums.length - i - 1);
            }
            return nums[nums.length - k];
        }
        for (int i = 0; i < nums.length - k + 1; i++) {
            for (int j = (nums.length - i) / 2 - 1; j >= 0; j--) {
                heapSortMin(nums, j, nums.length - i);
            }
            swap(nums, 0, nums.length - i - 1);
        }
        return nums[k - 1];
    }

    private static void heapSortMax(int[] nums, int index, int heapSize) {
        int max = index;
        int l = 2 * index + 1;
        int r = 2 * index + 2;
        if (l >= heapSize) {
            return;
        }
        if (nums[l] > nums[max]) {
            max = l;
        }
        if (r < heapSize && nums[r] > nums[max]) {
            max = r;
        }
        if (max == index) {
            return;
        }
        swap(nums, max, index);
        heapSortMax(nums, max, heapSize);
    }

    private static void heapSortMin(int[] nums, int index, int heapSize) {
        int min = index;
        int l = 2 * index + 1;
        int r = 2 * index + 2;
        if (l >= heapSize) {
            return;
        }
        if (nums[l] < nums[min]) {
            min = l;
        }
        if (r < heapSize && nums[r] < nums[min]) {
            min = r;
        }
        if (min == index) {
            return;
        }
        swap(nums, min, index);
        heapSortMin(nums, min, heapSize);
    }

    private static void swap(int[] nums, int i, int j) {
        int value = nums[i];
        nums[i] = nums[j];
        nums[j] = value;
    }
}
