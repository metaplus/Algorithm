package problem.hashmap;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lc448FindDisappearedNumbers {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        for (int num : nums) {

            if (nums[Math.abs(num) - 1] > 0) {
                nums[Math.abs(num) - 1] *= -1;
            }
        }
        List<Integer> result = new ArrayList<>(4);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result.add(i + 1);
            }
        }
        return result;
    }

        public List<Integer> findDisappearedNumbers2(int[] nums) {
        Set<Integer> set = new HashSet<>(nums.length);
        for (int i = 1; i <= nums.length; i++) {
            set.add(i);
        }
        for (int num : nums) {
            set.remove(num);
        }
        return new ArrayList<>(set);
    }
}
