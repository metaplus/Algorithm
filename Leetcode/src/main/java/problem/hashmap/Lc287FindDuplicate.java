package problem.hashmap;

import java.util.HashSet;
import java.util.Set;

public class Lc287FindDuplicate {


    public int findDuplicate(int[] nums) {
        for (int num : nums) {
            if(nums[Math.abs(num)-1]<0){
                return Math.abs(num);
            }
            nums[Math.abs(num)-1]*=-1;
        }
        return -1;
    }
    public int findDuplicate3(int[] nums) {
        int left = 1;
        int right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int sum = 0;
            for (int num : nums) {
                if (num <= mid) {
                    sum++;
                }
            }
            if (sum <= mid) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public int findDuplicate2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                return num;
            }
        }
        return -1;
    }
}
