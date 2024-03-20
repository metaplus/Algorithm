package problem.array;

public class Lc303NumArray {

    class NumArray {

        int[] nums;

        public NumArray(int[] nums) {
            if (nums.length > 0) {
                for (int i = 1; i < nums.length; i++) {
                    nums[i] += nums[i - 1];
                }
            }
            this.nums = nums;
        }

        public int sumRange(int left, int right) {
            return nums[right] - (left > 0 ? nums[left - 1] : 0);
        }
    }

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */
}
