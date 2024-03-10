package problem.array;

public class Lc80RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        if (nums.length < 2) {
            return 1;
        }
        int val = nums[0];
        int count = 1;
        int left = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != val) {
                val = nums[i];
                nums[left++] = nums[i];
                count = 1;
                continue;
            }
            if (++count > 2) {
                continue;
            }
            nums[left++] = nums[i];
        }
        return left;
    }

}
