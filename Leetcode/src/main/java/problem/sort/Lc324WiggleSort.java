package problem.sort;

import java.util.Arrays;

public class Lc324WiggleSort {

    public void wiggleSort(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }
        int[] counts = new int[max - min + 1];
        for (int num : nums) {
            counts[num - min]++;
        }
        int val = max;
        for (int i = 1; i < nums.length; i += 2) {
            for (int j = val; j >= min; j--) {
                if (counts[j - min] > 0) {
                    val = j;
                    counts[j - min]--;
                    break;
                }
            }
            nums[i] = val;
        }
        for (int i = 0; i < nums.length; i += 2) {
            for (int j = val; j >= min; j--) {
                if (counts[j - min] > 0) {
                    val = j;
                    counts[j - min]--;
                    break;
                }
            }
            nums[i] = val;
        }
    }
}
