package problem.array;

import java.util.ArrayList;
import java.util.List;

public class Lc228SummaryRanges {

    public List<String> summaryRanges(int[] nums) {
        if (nums.length == 0) {
            return new ArrayList<>(1);
        }
        int left = 0;
        List<String> result = new ArrayList<>();
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[left] == i - left) {
                continue;
            }
            if (i == left + 1) {
                result.add(Integer.toString(nums[left]));
            } else {
                result.add(nums[left] + "->" + nums[i - 1]);
            }
            left = i;
        }
        if (left == nums.length - 1) {
            result.add(Integer.toString(nums[left]));
        } else {
            result.add(nums[left] + "->" + nums[nums.length - 1]);

        }
        return result;
    }
}
