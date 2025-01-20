package problem.sort;

public class Lc283MoveZeroes {

    public void moveZeroes(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[count++] = nums[i];
            }
        }
        for (int i = count; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    public void moveZeroes3(int[] nums) {
        int zero = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (zero == -1) {
                    continue;
                }
                nums[zero] = nums[i];
                nums[i] = 0;
                zero += 1;
                continue;
            }
            if (zero == -1) {
                zero = i;
            }
        }
    }

    public void moveZeroes2(int[] nums) {
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                swap(nums, i, left);
                left++;
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
