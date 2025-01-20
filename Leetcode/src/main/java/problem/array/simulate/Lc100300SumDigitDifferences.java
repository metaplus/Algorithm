package problem.array.simulate;

import java.util.Arrays;

public class Lc100300SumDigitDifferences {

    public long sumDigitDifferences(int[] nums) {
        Arrays.sort(nums);
        long sum = 0;
        long countI = 0;
        long countJ = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                sum += countI;
                continue;
            }
            countI = 0;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == nums[i]) {
                    continue;
                }
                if (nums[j] == nums[j - 1]) {
                    countI += countJ;
                    continue;
                }
                countJ = 0;
                int left = nums[i];
                int right = nums[j];
                while (left > 0 || right > 0) {
                    if (left % 10 != right % 10) {
                        countJ++;
                    }
                    left /= 10;
                    right /= 10;
                }
                countI += countJ;
            }
            sum += countI;
        }
        return sum;
    }
}
