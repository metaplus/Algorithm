package problem.array;

public class Lc70SortColors {

    public void sortColors(int[] nums) {
        int[] count = new int[3];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                swap(nums, i, count[0] + count[1]);
                count[1]++;
                continue;
            }
            if (nums[i] == 0) {
                nums[count[0] + count[1] + count[2]] = 2;
                nums[count[0] + count[1]] = 1;
                nums[count[0]] = 0;
                count[0]++;
                continue;
            }
            count[2]++;
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
