package problem.array;

public class Lc209MinSubArrayLen {
    public int minSubArrayLen(int target, int[] nums) {
        int window = Integer.MAX_VALUE;
        int sum = 0;
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target) {
                return 1;
            }
            sum += nums[i];
            if (sum < target) {
                continue;
            }
            window = Math.min(window, i - left + 1);
            for (int j = left; j < i; j++) {
                sum -= nums[j];
                left = j + 1;
                if (sum >= target) {
                    continue;
                }
                window = Math.min(window, i - j + 1);
                break;
            }
        }
        return window < Integer.MAX_VALUE ? window : 0;
    }
}
