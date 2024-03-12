package problem.array;

public class Lc713NumSubarrayProductLessThanK {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int left = -1;
        int mul = -1;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= k) {
                left = -1;
                mul = -1;
                continue;
            }
            if (left < 0) {
                left = i;
                mul = nums[i];
                count++;
                continue;
            }
            mul *= nums[i];
            for (int j = left; j < i && mul >= k; j++) {
                mul /= nums[j];
                left = j + 1;
            }
            count += i - left + 1;
        }
        return count;
    }
}
