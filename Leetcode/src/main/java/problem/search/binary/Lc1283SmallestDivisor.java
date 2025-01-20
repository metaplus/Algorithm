package problem.search.binary;

public class Lc1283SmallestDivisor {

    public int smallestDivisor(int[] nums, int threshold) {
        int left = 1;
        int right = nums[0];
        for (int num : nums) {
            right = Math.max(right, num);
        }
        while (left < right) {
            int mid = left + (right - left) / 2;
            int sum = 0;
            for (int num : nums) {
                sum += (mid - 1 + num) / mid;
            }
            if (sum > threshold) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left ;
    }
}
