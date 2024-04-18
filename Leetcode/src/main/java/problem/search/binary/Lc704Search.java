package problem.search.binary;

public class Lc704Search {

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
                continue;
            }
            right = mid;
        }
        return left == nums.length || nums[left] != target ? -1 : left;
    }
}
