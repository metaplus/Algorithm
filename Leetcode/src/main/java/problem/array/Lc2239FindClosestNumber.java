package problem.array;

public class Lc2239FindClosestNumber {

    public int findClosestNumber(int[] nums) {
        int absMin = Integer.MAX_VALUE;
        int result = 0;
        for (int num : nums) {
            int abs = Math.abs(num);
            if (abs < absMin) {
                result = num;
                absMin = abs;
                continue;
            }
            if (abs > absMin) {
                continue;
            }
            if (num > result) {
                result = num;
            }
        }
        return result;
    }
}
