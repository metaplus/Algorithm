package problem.greedy;

public class Lc410SplitArray {

    public int splitArray(int[] nums, int k) {
        int sum = 0;
        int max = 0;
        for (int num : nums) {
            sum += num;
            max = Math.max(max, num);
        }
        int left = max;
        int right = sum;
        while (left < right) {
            int mid = left + right >> 1;
            if (splitGroup(nums, mid) > k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public int splitGroup(int[] nums, int sumMax) {
        int group = 1;
        int sum = 0;
        for (int num : nums) {
            if (sum + num <= sumMax) {
                sum += num;
                continue;
            }
            group++;
            sum = num;
        }
        return group;
    }
}
