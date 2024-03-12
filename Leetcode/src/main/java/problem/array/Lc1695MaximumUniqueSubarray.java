package problem.array;

public class Lc1695MaximumUniqueSubarray {

    public int maximumUniqueSubarray(int[] nums) {
        int left = 0;
        int sum = 0;
        int sumMax = 0;
        boolean[] counts = new boolean[10001];
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (!counts[nums[i]]) {
                counts[nums[i]] = true;
                sumMax = Math.max(sumMax, sum);
                continue;
            }
            for (int j = left; j < i; j++) {
                left = j + 1;
                sum -= nums[j];
                if (nums[i] == nums[j]) {
                    break;
                }
                counts[nums[j]] = false;
            }
            sumMax = Math.max(sumMax, sum);
        }
        return sumMax;
    }
}
