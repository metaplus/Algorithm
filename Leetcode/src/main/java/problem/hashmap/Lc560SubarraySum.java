package problem.hashmap;

import java.util.HashMap;
import java.util.Map;

public class Lc560SubarraySum {

    public int subarraySum(int[] nums, int k) {
        int result = 0;
        int sum = 0;
        Map<Integer, Integer> pre = new HashMap<>();
        pre.put(0, 1);
        for (int num : nums) {
            sum += num;
            result += pre.getOrDefault(sum - k, 0);
            pre.merge(sum, 1, Integer::sum);
        }
        return result;
    }


    //FA
    public int subarraySum2(int[] nums, int k) {

        int sum = 0;
        int left = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum == k) {
                count++;
                continue;
            }
            if (sum < k) {
                continue;
            }
            while (left < i) {
                sum -= nums[left];
                left++;
                if (sum == k) {
                    count++;
                    continue;
                }
                if (sum < k) {
                    break;
                }
            }
        }
        return count;
    }


    public int subarraySum3(int[] nums, int k) {

        int preSum = 0;
        Map<Integer, Integer> preCounts = new HashMap<>();
        preCounts.put(0, 1);
        int arr = 0;
        for (int i = 0; i < nums.length; i++) {
            preSum += nums[i];
            arr += preCounts.getOrDefault(preSum - k, 0);
            preCounts.merge(preSum, 1, Integer::sum);
        }
        return arr;
    }
}
