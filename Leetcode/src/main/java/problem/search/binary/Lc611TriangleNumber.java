package problem.search.binary;

import java.util.Arrays;

public class Lc611TriangleNumber {

    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                int left = j + 1;
                int right = nums.length;
                while (left < right) {
                    int mid = left + (right - left) / 2;
                    if (nums[i] + nums[j] > nums[mid]) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }
                sum += left - j - 1;
            }
        }
        return sum;
    }
}
