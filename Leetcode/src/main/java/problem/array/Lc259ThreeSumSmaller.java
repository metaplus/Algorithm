package problem.array;

import java.util.Arrays;

public class Lc259ThreeSumSmaller {

    public int threeSumSmaller(int[] nums, int target) {
        if (nums.length < 3) {
            return 0;
        }
        int count = 0;
        Arrays.sort(nums);
        for (int left = 0; left < nums.length - 2; left++) {
            if (nums[left] + nums[left + 1] + nums[left + 2] >= target) {
                break;
            }
            if (nums[left] + nums[nums.length - 2] + nums[nums.length - 1] < target) {
                for (int i = 1; i <= nums.length - left - 2; i++) {
                    count += i;
                }
                continue;
            }
            for (int mid = left + 1, right = nums.length - 1; mid < right; ) {
                int sum = nums[left] + nums[mid] + nums[right];
                if (sum >= target) {
                    right--;
                    continue;
                }
                count += right - mid;
                mid++;
            }
        }
        return count;
    }
}
