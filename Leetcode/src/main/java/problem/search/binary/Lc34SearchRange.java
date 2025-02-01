package problem.search.binary;

import java.util.Arrays;

public class Lc34SearchRange {

    public int[] searchRange(int[] nums, int target) {
        if (nums == null
                || nums.length == 0
                || target < nums[0]
                || target > nums[nums.length - 1]) {
            return new int[]{-1, -1};
        }
        int[] result = new int[2];
        Arrays.fill(result, -1);
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                if (mid - 1 < 0 || nums[mid - 1] < nums[mid]) {
                    result[0] = mid;
                    break;
                } else {
                    right = mid - 1;
                }
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (result[0] < 0) {
            return result;
        }
        left = result[0];
        right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                if (mid + 1 == nums.length || nums[mid + 1] > nums[mid]) {
                    result[1] = mid;
                    break;
                } else {
                    left = mid + 1;
                }
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

    public int[] searchRange3(int[] nums, int target) {
        if (nums.length == 0
                || target > nums[nums.length - 1]
                || target < nums[0]) {
            return new int[]{-1, -1};
        }
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if (nums[left] != target) {
            return new int[]{-1, -1};
        }
        int begin = left;
        right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return new int[]{begin, left - 1};
    }

    public int[] searchRange2(int[] nums, int target) {
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
