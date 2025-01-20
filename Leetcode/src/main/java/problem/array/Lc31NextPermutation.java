package problem.array;

public class Lc31NextPermutation {

    public void nextPermutation(int[] nums) {
        if (nums.length < 2) {
            return;
        }
        int pos = 0;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                int next = i + 1;
                for (int j = i + 2; j < nums.length; j++) {
                    if (nums[j] > nums[i] && nums[j] <= nums[next]) {
                        next = j;
                    }
                }
                swap(nums, i, next);
                pos = i + 1;
//                for (int j = i + 1; j < nums.length && nums[j] > nums[j - 1]; j++) {
//                    swap(nums, j, j - 1);
//                }
                break;
            }
        }
        for (int left = pos, right = nums.length - 1; left < right; left++, right--) {
            swap(nums, left, right);
        }
    }

    public void nextPermutation2(int[] nums) {

        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                for (int j = nums.length - 1; j >= i; j--) {
                    if (nums[j] <= nums[i - 1]) {
                        continue;
                    }
                    swap(nums, j, i - 1);
                    break;
                }
                for (int j = i; j < i + (nums.length - i) / 2; j++) {
                    swap(nums, j, i + nums.length - 1 - j);
                }
                return;
            }
        }
        for (int i = 0; i < nums.length / 2; i++) {
            swap(nums, i, nums.length - 1 - i);
        }
    }

    private void swap(int[] arr, int i, int j) {
        if (i != j) {
            int val = arr[i];
            arr[i] = arr[j];
            arr[j] = val;
        }
    }
}
