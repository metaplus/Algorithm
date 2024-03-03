package problem.sort;

public class Lc283MoveZeroes {

    public void moveZeroes(int[] nums) {
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
}
