package problem.hashmap;

import java.util.Arrays;

public class Lc41FirstMissingPositive {


    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0) {
                nums[i] = Integer.MAX_VALUE / 2;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (Math.abs(nums[i]) <= nums.length) {
                if (nums[Math.abs(nums[i]) - 1] > 0) {
                    nums[Math.abs(nums[i]) - 1] *= -1;
                }
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }

    public int firstMissingPositive2(int[] nums) {
//        int min = Integer.MAX_VALUE;
//        int max = Integer.MIN_VALUE;
//        for (int num : nums) {
//            min = Math.min(min, num);
//            max = Math.max(max, num);
//        }
//        int[] counts = new int[max - min + 1];
//        for (int num : nums) {
//            counts[num - min]++;
//        }
//        for (int i = 1; i < counts.length; i++) {
//            counts[i] += counts[i - 1];
//        }
//        int[] sort = new int[nums.length];
//        for (int i = nums.length - 1; i >= 0; i--) {
//            sort[--counts[nums[i] - min]] = nums[i];
//        }
        Arrays.sort(nums);
        int[] sort = nums;
        int val = 1;
        for (int i = 0; i < sort.length; i++) {
            if (sort[i] < val) {
                continue;
            }
            if (sort[i] == val) {
                val++;
                continue;
            }
            break;
        }
        return val;
    }
}
