package problem.search;

public class Lc34SearchRange {

    public int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if (left == nums.length || nums[left] > target) {
            return new int[]{-1, -1};
        }
        while (left - 1 >= 0 && nums[left - 1] == target) {
            left--;
        }
        while (right + 1 < nums.length && nums[right + 1] == target) {
            right++;
        }
        return new int[]{left, right};
    }
}
