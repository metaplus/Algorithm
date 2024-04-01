package problem.array;

public class Lc189Rotate {

    public void rotate(int[] nums, int k) {
        if (nums.length == 1) {
            return;
        }
        k %= nums.length;
        int[] temp = new int[k];
        for (int i = nums.length - k; i < nums.length; i++) {
            temp[i - nums.length + k] = nums[i];
        }
        for (int i = nums.length - 1; i >= k; i--) {
            nums[i] = nums[i - k];
        }
        for (int i = 0; i < temp.length; i++) {
            nums[i] = temp[i];
        }
    }
}
