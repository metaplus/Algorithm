package problem.sort;

public class Lc75SortColors {

    public void sortColors(int[] nums) {
        int count0 = 0;
        int count1 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                swap(nums, i, count1++ + count0);
                continue;
            }
            if (nums[i] == 0) {
                swap(nums, i, count1 + count0);
                swap(nums, count1 + count0, count0++);
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
