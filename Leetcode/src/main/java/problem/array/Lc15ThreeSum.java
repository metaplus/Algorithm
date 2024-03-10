package problem.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lc15ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
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
