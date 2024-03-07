package problem.greedy;

public class Lc45Jump {

    public int jump(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        int right = 0;
        for (int i = 1; right < nums.length; i++) {
            int max = right;
            for (int j = right; j >= 0; j--) {
                if (nums[j] + j > max) {
                    max = nums[j] + j;
                }
            }
            if (max >= nums.length - 1) {
                return i;
            }
            right = max;
        }
        return -1;
    }
}
