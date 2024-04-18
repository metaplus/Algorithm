package problem.search.binary;

public class Lc33Search {

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[right] < nums[mid]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        int mid = left;
        if (nums[mid] == target) {
            return mid;
        }
        if (nums[mid] > target || (mid - 1 >= 0 && nums[mid - 1] < target)) {
            return -1;
        }
        if (nums[nums.length - 1] >= target) {
            left = mid;
            right = nums.length;
            while (left < right) {
                int mid1 = (left + right) / 2;
                if (nums[mid1] < target) {
                    left = mid1 + 1;
                } else {
                    right = mid1;
                }
            }
            return left == nums.length || nums[left] != target ? -1 : left;
        }
        left = 0;
        right = mid - 1;
        while (left < right) {
            int mid1 = (left + right) / 2;
            if (nums[mid1] < target) {
                left = mid1 + 1;
            } else {
                right = mid1;
            }
        }
        return left == mid || nums[left] != target ? -1 : left;
    }
}
