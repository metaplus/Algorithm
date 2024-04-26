package problem.search.binary;

import java.util.Arrays;
import java.util.Comparator;

public class Lc1099TwoSumLessThanK {

    public int twoSumLessThanK(int[] nums, int k) {
        if (nums.length < 2) {
            return -1;
        }
        Arrays.sort(nums);
        if (nums[0] + nums[1] >= k) {
            return -1;
        }
        int sumMax = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] + nums[i + 1] >= k) {
                break;
            }
            int left = i + 1;
            int right = nums.length;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] + nums[i] < k) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            sumMax = Math.max(nums[i] + nums[left - 1], sumMax);
        }
        return sumMax;
    }

    // slow
    public int twoSumLessThanK3(int[] nums, int k) {
        if (nums.length < 2) {
            return -1;
        }
        int[][] sort = new int[nums.length][2];
        Arrays.setAll(sort, i -> new int[]{nums[i], i});
        Arrays.sort(sort, Comparator.comparingInt(arr -> arr[0]));
        if (sort[0][0] + sort[1][0] >= k) {
            return -1;
        }
        int left = 0;
        int right = sort.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (sort[0][0] + sort[mid][0] < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        left = 0;
        right--;
        int sumMax = 0;
        while (left < right) {
            int sum = sort[left][0] + sort[right][0];
            if (sum < k) {
                sumMax = Math.max(sumMax, sum);
                left++;
                continue;
            }
            right--;
        }
        return sumMax;
    }

    // fine
    public int twoSumLessThanK2(int[] nums, int k) {
        Arrays.sort(nums);
        int sumMax = -1;
        for (int left = 0, right = nums.length - 1; left < right; ) {
            if (nums[left] + nums[left + 1] >= k) {
                break;
            }
            int sum = nums[left] + nums[right];
            if (sum >= k) {
                right--;
                continue;
            }
            sumMax = Math.max(sum, sumMax);
            left++;
        }
        return sumMax;
    }
}
