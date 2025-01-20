package problem.search.binary;

public class Lc410SplitArray {


    public int splitArray(int[] nums, int k) {
        int left = nums[0];
        int right = nums[0];
        for (int i = 1; i < nums.length; i++) {
            left = Math.max(nums[i], left);
            right += nums[i];
        }
        while (left < right) {
            int count = 1;
            int sum = 0;
            int mid = left + (right - left) / 2;
            for (int i = 0; i < nums.length; i++) {
                if (sum + nums[i] <= mid) {
                    sum += nums[i];
                    continue;
                }
                sum = nums[i];
                count++;
            }
            if (count > k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public int splitArray2(int[] nums, int k) {
        int sum = 0;
        int max = 0;
        for (int num : nums) {
            sum += num;
            max = Math.max(max, num);
        }
        int left = max;
        int right = sum;
        while (left < right) {
            int mid = left + right >> 1;
            if (splitGroup(nums, mid) > k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public int splitGroup(int[] nums, int sumMax) {
        int group = 1;
        int sum = 0;
        for (int num : nums) {
            if (sum + num <= sumMax) {
                sum += num;
                continue;
            }
            group++;
            sum = num;
        }
        return group;
    }
}
