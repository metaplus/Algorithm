package problem.greedy;

public class Lc55CanJump {

    public boolean canJump(int[] nums) {
        if (nums.length < 2) {
            return true;
        }
        if (nums[0] == 0) {
            return false;
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] += i;
        }
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == i && i < nums.length - 1) {
                continue;
            }
            if (max < i) {
                return false;
            }
            if (i == nums.length - 1 || nums[i] >= nums.length - 1) {
                return true;
            }
            max = Math.max(max, nums[i]);
        }
        return false;
    }
}
