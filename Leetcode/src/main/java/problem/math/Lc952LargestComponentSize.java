package problem.math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Lc952LargestComponentSize {

    //timeout
    public int largestComponentSize(int[] nums) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        List<Integer> primes = findPrimes(max);
        List<Integer>[] graph = new List[max + 1];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (Integer prime : primes) {
                    if (nums[i] % prime == 0 && nums[j] % prime == 0) {
                        if (Objects.isNull(graph[i])) {
                            graph[i] = new ArrayList(4);
                        }
                        graph[i].add(j);
                        if (Objects.isNull(graph[j])) {
                            graph[j] = new ArrayList(4);
                        }
                        graph[j].add(i);
                        break;
                    }
                }
            }
        }
        int sumMax = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                sumMax = Math.max(sumMax, dfs(nums, i, graph));
            }
        }
        return sumMax;
    }

    private int dfs(int[] nums, int i, List<Integer>[] graph) {
        if (i < 0 || i > nums.length - 1) {
            return 0;
        }
        if (nums[i] < 0) {
            return 0;
        }
        int sum = 1;
        nums[i] *= -1;
        if (Objects.nonNull(graph[i])) {
            for (Integer j : graph[i]) {
                sum += dfs(nums, j, graph);
            }
        }
        return sum;
    }

    private List<Integer> findPrimes(int max) {
        boolean[] primes = new boolean[max];
        Arrays.fill(primes, true);
        for (int i = 2; i < primes.length; i++) {
            if (primes[i]) {
                for (int j = i + i; j < primes.length; j += i) {
                    primes[j] = false;
                }
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 2; i < primes.length; i++) {
            if (primes[i]) {
                res.add(i);
            }
        }
        return res;
    }
}
