package problem.math;

public class Lc1979FindGCD {

    public int findGCD(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        for (int num : nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        for (int i = min; i > 0; i--) {
            if (min % i == 0 && max % i == 0) {
                return i;
            }
        }
        return -1;
    }
}
