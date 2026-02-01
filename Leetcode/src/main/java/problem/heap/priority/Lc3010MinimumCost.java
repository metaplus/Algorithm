package problem.heap.priority;

public class Lc3010MinimumCost {

    public int minimumCost(int[] nums) {
        if (nums.length < 4) {
            int sum = 0;
            for (int num : nums) {
                sum += num;
            }
            return sum;
        }
        int first = 0;
        int second = 0;
        for (int i = 1; i < nums.length; i++) {
            if (first == 0) {
                first = nums[i];
                continue;
            }
            if (second == 0 ||nums[i] < second) {
                if (nums[i] < first) {
                    second = first;
                    first = nums[i];
                    continue;
                }
                second = nums[i];
            }
        }
        return nums[0] + first + second;
    }
}
