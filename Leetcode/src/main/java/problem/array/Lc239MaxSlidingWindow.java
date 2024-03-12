package problem.array;

public class Lc239MaxSlidingWindow {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] windows = new int[nums.length - k + 1];
        int max = Integer.MIN_VALUE;
        int[] counts = new int[20000 + 1];
        for (int i = 0; i < nums.length; i++) {
            counts[nums[i] + 10000]++;
            if (nums[i] > max) {
                max = nums[i];
            }
            if (i < k - 1) {
                continue;
            }
            if (i == k - 1) {
                windows[i - k + 1] = max;
                continue;
            }
            if (counts[nums[i - k] + 10000]-- > 1) {
                windows[i - k + 1] = max;
                continue;
            }
            if (nums[i - k] != max) {
                windows[i - k + 1] = max;
                continue;
            }
            for (int val = max - 1; val >= -10000; val--) {
                if (counts[val + 10000] > 0) {
                    max = val;
                    windows[i - k + 1] = max;
                    break;
                }
            }
        }
        return windows;
    }
}
