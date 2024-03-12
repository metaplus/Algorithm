package problem.array;

public class Lc674FindLengthOfLCIS {

    public int findLengthOfLCIS(int[] nums) {
        int left = 0;
        int len = 1;
        for (int i = 1; i < nums.length; i++) {

            if (nums[i - 1] < nums[i]) {
                len = Math.max(len, i - left + 1);
                continue;
            }
            left = i;
        }
        return len;
    }
}
