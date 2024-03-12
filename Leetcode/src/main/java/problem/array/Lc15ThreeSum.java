package problem.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lc15ThreeSum {


    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> results = new ArrayList<>();
        for (int left = 0; left < nums.length - 2; left++) {
            if (left > 0 && nums[left] == nums[left - 1]) {
                continue;
            }
            if (nums[left] + nums[left + 1] + nums[left + 2] > 0) {
                continue;
            }
            if (nums[left] + nums[nums.length - 2] + nums[nums.length - 1] < 0) {
                continue;
            }
            for (int mid = left + 1, right = nums.length - 1; mid < right; ) {
                if (mid > left + 1 && nums[mid] == nums[mid - 1]) {
                    mid++;
                    continue;
                }
                int sum = nums[left] + nums[mid] + nums[right];
                if (sum > 0) {
                    right--;
                    continue;
                }
                if (sum < 0) {
                    mid++;
                    continue;
                }
                List<Integer> res = new ArrayList<>(3);
                res.add(nums[left]);
                res.add(nums[mid]);
                res.add(nums[right]);
                results.add(res);
                mid++;
            }
        }
        return results;
    }

    public List<List<Integer>> threeSum2(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> results = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1, k = nums.length - 1; j < k; ) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    j++;
                    continue;
                }
                int sum = nums[j] + nums[k];
                if (sum + nums[i] == 0) {
                    List<Integer> list = new ArrayList<>(3);
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    results.add(list);
                    j++;
                    k--;
                    continue;
                }
                if (sum + nums[i] > 0) {
                    k--;
                    continue;
                }
                j++;
            }
        }
        return results;
    }
}
