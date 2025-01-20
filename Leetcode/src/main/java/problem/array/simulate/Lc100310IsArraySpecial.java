package problem.array.simulate;

public class Lc100310IsArraySpecial {

    public boolean isArraySpecial(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        for (int i = 1; i < nums.length; i++) {
            if (((nums[i] & 1) > 0) ^ ((nums[i - 1] & 1) > 0)) {
                continue;
            }
            return false;
        }
        return true;
    }
}
