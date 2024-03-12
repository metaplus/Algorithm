package problem.array;

public class Lc795NumSubarrayBoundedMax {

    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        if (nums.length < 2) {
            return nums[0] > right || nums[0] < left ? 0 : 1;
        }
        int count = 0;
        int upLast = -1;
        int indexLast = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > right) {
                upLast = i;
                indexLast = -1;
                continue;
            }
            if (nums[i] >= left) {
                indexLast = i;
            }
            if (indexLast < 0) {
                continue;
            }
            count += indexLast - upLast;
        }
        return count;
    }
}
