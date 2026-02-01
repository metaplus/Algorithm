package problem.array;

import java.util.Arrays;

public class Lc628MaximumProduct {

    public int maximumProduct(int[] nums) {
        int product = nums[0] * nums[1] * nums[2];
        int len = nums.length;
        if (len > 3) {
            Arrays.sort(nums);
            product = Math.max(nums[len - 1] * nums[len - 2] * nums[len - 3], product);
            product = Math.max(nums[len - 1] * nums[0] * nums[1], product);
        }
        return product;
    }
}
