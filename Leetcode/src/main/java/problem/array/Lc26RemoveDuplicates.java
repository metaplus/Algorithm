package problem.array;

public class Lc26RemoveDuplicates {

    public int removeDuplicates(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }
        int val = nums[0];
        int left = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != val) {
                val = nums[i];
                nums[left++] = nums[i];
            }
        }
        return left;
    }
}
