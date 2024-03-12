package problem.array;

public class Lc1658MinOperations {

    public int minOperations(int[] nums, int x) {
        int sum = 0;
        int min = nums[0];
        for (int num : nums) {
            sum += num;
            min = Math.min(min, num);
        }
        int expect = sum - x;
        if (expect == 0) {
            return nums.length;
        }
        if (expect < min) {
            return -1;
        }
        int lenMax = 0;
        int left = 0;
        int sumWindow = 0;
        for (int i = 0; i < nums.length; i++) {
            sumWindow += nums[i];
            if (sumWindow == expect) {
                lenMax = Math.max(lenMax, i - left + 1);
                sumWindow -= nums[left];
                left++;
                continue;
            }
            if (sumWindow > expect) {
                for (int j = left; j < i && sumWindow >= expect; j++) {
                    sumWindow -= nums[left];
                    left = j + 1;
                    if (sumWindow == expect) {
                        lenMax = Math.max(lenMax, i - left + 1);
                    }
                }
            }
        }
        if (lenMax == 0) {
            return -1;
        }
        return nums.length - lenMax;
    }
}
