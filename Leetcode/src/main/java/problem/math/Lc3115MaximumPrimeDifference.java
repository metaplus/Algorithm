package problem.math;

import java.util.Arrays;

public class Lc3115MaximumPrimeDifference {

    public int maximumPrimeDifference(int[] nums) {
        boolean[] primes = new boolean[101];
        Arrays.fill(primes, true);
        for (int i = 2; i < 101; i++) {
            if (primes[i]) {
                for (int j = i * 2; j < 101; j += i) {
                    primes[j] = false;
                }
            }
        }
        primes[1] = false;
        int left = 0;
        while (left < nums.length) {
            if (primes[nums[left]]) {
                break;
            }
            left++;
        }
        if (left >= nums.length) {
            return -1;
        }
        int right = nums.length - 1;
        while (right >= left) {
            if (primes[nums[right]]) {
                break;
            }
            right--;
        }
        return right - left;
    }
}
