package problem.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Lc2464ValidSubarraySplit {

    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    // time 10x
    public int validSubarraySplit(int[] nums) {
        if (Objects.isNull(nums) || nums.length < 1) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
//        int max = 0;
//        for (int num : nums) {
//            max = Math.max(max, num);
//        }
//        List<Integer> primes = findPrimes(max);
        int[][] dp = new int[nums.length][nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 1) {
                dp[i][i] = 1;
            }
            for (int j = i + 1; j < nums.length; j++) {
//                dp[i][j] = commonPrimes(nums[i], nums[j], primes) ? 1 : 0;
                dp[i][j] = gcd(nums[i], nums[j]) > 1 ? 1 : 0;
            }
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            for (int j = i + 1; j < nums.length; j++) {
                if (dp[i][j] > 0) {
                    continue;
                }
                for (int k = i; k < j; k++) {
                    if (dp[i][k] > 0 && dp[k + 1][j] > 0) {
                        if (dp[i][j] > 0) {
                            dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j]);
                        } else {
                            dp[i][j] = dp[i][k] + dp[k + 1][j];
                        }
                    }
                }
            }
        }
        int res = dp[0][nums.length - 1];
        return res > 0 ? res : -1;
    }

    private boolean commonPrimes(int left, int right, List<Integer> primes) {
        for (Integer prime : primes) {
            if (prime > left || prime > right) {
                break;
            }
            if (left % prime == 0 && right % prime == 0) {
                return true;
            }
        }
        return false;
    }

    private List<Integer> findPrimes(int val) {
        List<Integer> res = new ArrayList<>(8);
        boolean[] primes = new boolean[val + 1];
        Arrays.fill(primes, true);
        for (int i = 2; i <= val; i++) {
            if (primes[i]) {
                for (int j = i << 1; j < val; j += i) {
                    primes[j] = false;
                }
                res.add(i);
            }
        }
        return res;
    }
}
