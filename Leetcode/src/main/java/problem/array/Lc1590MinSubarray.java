package problem.array;

public class Lc1590MinSubarray {


    public int minSubarray(int[] nums, int p) {
        long[] prefix = new long[nums.length];
        prefix[0] = nums[0];
        int acceptWidth = -1;
        for (int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }
        for (int i = prefix.length - 1; i >= 0; i--) {
            if (prefix[i] % p == 0) {
                acceptWidth = prefix.length - 1 - i;
            }
        }
        if (prefix[nums.length - 1] % p == 0) {
            return 0;
        }
        int maxWidth = nums.length - 1;
        for (int width = 1; width <= maxWidth; width++) {
            if (acceptWidth>=0 && width >= acceptWidth) {
                return width;
            }
            for (int left = 0; ; left++) {
                int right = left + width - 1;
                if (right >= nums.length) {
                    break;
                }
                long remove = prefix[right] - (left > 0 ? prefix[left - 1] : 0);
                long sum = prefix[nums.length - 1] - remove;
                if (sum % p == 0) {
                    return width;
                }
            }
        }
        return -1;
    }
}
