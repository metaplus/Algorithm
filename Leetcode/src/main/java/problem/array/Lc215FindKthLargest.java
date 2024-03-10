package problem.array;

public class Lc215FindKthLargest {

    public int findKthLargest(int[] nums, int k) {
        if (nums.length < 2) {
            return nums[0];
        }
        int min = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        int[] counts = new int[max - min + 1];
        for (int num : nums) {
            counts[num - min]++;
        }
        if (counts[max - min] >= k) {
            return max;
        }
        for (int i = max - min - 1; i >= 0; i--) {
            counts[i] += counts[i + 1];
            if (counts[i] >= k) {
                return i + min;
            }
        }
        return -1;
    }

    public int findKthLargest2(int[] nums, int k) {
        int reverse = nums.length + 1 - k;
        if (k < reverse) {
            for (int i = 0; i < k; i++) {
                maxHeap(nums, i, nums.length - i);
            }
            return nums[k - 1];
        }
        for (int i = 0; i < reverse; i++) {
            minHeap(nums, i, nums.length - i);
        }
        return nums[reverse - 1];
    }

    private void maxHeap(int[] nums, int left, int count) {
        for (int i = count / 2 - 1 + left; i >= left; i--) {
            int next = 2 * (i - left) + 1 + left;
            if (nums[next] > nums[i]) {
                if (next + 1 < count && nums[next + 1] > nums[next]) {
                    swap(nums, next + 1, i);
                    continue;
                }
                swap(nums, next, i);
                continue;
            }
            if (next + 1 < count && nums[next + 1] > nums[i]) {
                swap(nums, next + 1, i);
            }
        }
    }

    private void minHeap(int[] nums, int left, int count) {
        for (int i = count / 2 - 1 + left; i >= left; i--) {
            int next = 2 * (i - left) + 1 + left;
            if (nums[next] < nums[i]) {
                if (next + 1 < count && nums[next + 1] < nums[next]) {
                    swap(nums, next + 1, i);
                    continue;
                }
                swap(nums, next, i);
                continue;
            }
            if (next + 1 < count && nums[next + 1] < nums[i]) {
                swap(nums, next + 1, i);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        if (i != j) {
            int val = nums[i];
            nums[i] = nums[j];
            nums[j] = val;
        }
    }
}
