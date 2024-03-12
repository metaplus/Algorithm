package problem.array;

public class Lc487FindMaxConsecutiveOnes {

    public int findMaxConsecutiveOnes(int[] nums) {
        int left = 0;
        int posZero = -1;
        int lenMax = 0;
        for (int i = 0; i < nums.length; i++) {
            int len = i - left + 1;
            if (nums[i] == 1) {
                lenMax = Math.max(lenMax, len);
                continue;
            }
            if (posZero < 0) {
                posZero = i;
                lenMax = Math.max(lenMax, len);
                continue;
            }
            left = posZero + 1;
            posZero = i;
        }
        return lenMax;
    }
}
