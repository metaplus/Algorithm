package problem.array;

public class Lc995MinKBitFlips {

    public int minKBitFlips(int[] nums, int k) {
        int flip = 0;
        int edge = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i >= k && nums[i - k] > 1) {
                edge ^= 1;
                nums[i - k] -= 2;
            }
            if (nums[i] != edge) {
                continue;
            }
            if (i + k - 1 > nums.length - 1) {
                return -1;
            }
            flip++;
            edge ^= 1;
            nums[i] += 2;
        }
        return flip;
    }

    // timeout
    public int minKBitFlips2(int[] nums, int k) {
        int left = 0;
        int flip = 0;
        int countZero = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                countZero++;
            }
            int len = i - left + 1;
            if (len < k) {
                continue;
            }
            if (nums[left] == 1) {
                left++;
                continue;
            }
            flip++;
            countZero = k - countZero;
            if (countZero == 0) {
                left = i + 1;
                continue;
            }
            int next = -1;
            for (int j = left + 1; j <= i; j++) {
//                nums[j] = 1 - nums[j];
                nums[j] ^= 1;
                if (nums[j] == 0 && next < 0) {
                    next = j;
                }
            }
            left = next;
        }
        return countZero > 0 ? -1 : flip;
    }
}
