package problem.search.binary;

import java.util.Arrays;

public class Lc268MissingNumber {

    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + right >> 1;
            if (nums[mid] <= mid) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left] <= left ? left + 1 : left;
    }
}
