package problem.array;

public class Lc1493LongestSubarray {

    public int longestSubarray(int[] nums) {
        int zeroPos = -1;
        int left = 0;
        int lenMax = 0;
        for (int i = 0; i < nums.length; i++) {
            int len = i - left + 1;
            if (nums[i] == 1) {
                if (zeroPos >= 0) {
                    len--;
                }
                lenMax = Math.max(lenMax, len);
                continue;
            }
            if (zeroPos < 0) {
                zeroPos = i;
                lenMax = Math.max(lenMax, len - 1);
                continue;
            }
            left = zeroPos + 1;
            zeroPos = i;
        }
        return zeroPos < 0 ? lenMax - 1 : lenMax;
    }
}
