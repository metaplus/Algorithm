package problem.hashmap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Lc1TwoSum {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(target-nums[i])){
                return new int[]{map.get(target-nums[i]),i};
            }
            map.put(nums[i],i);
        }
        return nums;
    }

        public int[] twoSum2(int[] nums, int target) {
        int[][] sort = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            sort[i][0] = nums[i];
            sort[i][1] = i;
        }
        Arrays.sort(sort, Comparator.comparingInt(arr -> arr[0]));
        for (int left = 0, right = nums.length - 1; left < right; ) {
            int sum = sort[left][0] + sort[right][0];
            if (sum < target) {
                left++;
                continue;
            }
            if (sum > target) {
                right--;
                continue;
            }
            return new int[]{sort[left][1], sort[right][1]};
        }
        return null;
    }


}
