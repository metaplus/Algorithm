package problem.greedy;

public class Lc376WiggleMaxLength {

    public int wiggleMaxLength(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }
        if (nums.length == 2) {
            return nums[0] != nums[1] ? 2 : 1;
        }
        int len = 1;
        int last = nums[0];
        boolean up = false;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == last) {
                continue;
            }
            if (len == 1) {
                up = nums[i] > last;
                last = nums[i];
                len++;
                continue;
            }
            if (up ^ (nums[i] > last)) {
                up = !up;
                last = nums[i];
                len++;
            }
            if (up && nums[i] > last) {
                last = nums[i];
            }
            if (!up && nums[i] < last) {
                last = nums[i];
            }
        }
        return len;
    }
}
