package problem.hashmap;

public class Lc1004LongestOnes {
    public int longestOnes(int[] nums, int k) {
        int left = 0;
        int countZero = 0;
        int lenMax = 0;
        for (int i = 0; i < nums.length; i++) {
            int len = i - left + 1;
            if (nums[i] == 1) {
                lenMax = Math.max(lenMax, len);
                continue;
            }
            if (++countZero <= k) {
                lenMax = Math.max(lenMax, len);
                continue;
            }
            for (int j = left; j <= i; j++) {
                if (nums[j] == 0) {
                    left = j + 1;
                    countZero--;
                    break;
                }
            }
        }
        return lenMax;
    }

    public int longestOnes1(int[] nums, int k) {
        int zeros = nums[0] == 0 && k > 0 ? 1 : 0;
        int ones = nums[0] == 1 ? 1 : 0;
        int countMax = k > 0 ? 1 : ones;
        int left = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == 1) {
                ones++;
                countMax = Math.max(ones + zeros, countMax);
                continue;
            }
            zeros++;
            while (zeros > k) {
                if (nums[left] == 1) {
                    ones--;
                } else {
                    zeros--;
                }
                left++;
            }
            if (k == 0) {
                left = i + 1;
            }
            countMax = Math.max(ones + zeros, countMax);
        }
        return countMax;
    }
}
