package problem.dp;

import java.util.HashMap;
import java.util.Map;

public class Lc1218LongestSubsequence {

    public int longestSubsequence(int[] arr, int difference) {
        Map<Integer, Integer> dp = new HashMap<>();
        dp.put(arr[0], 1);
        int lenMax = 1;
        for (int i = 1; i < arr.length; i++) {
            int len = dp.getOrDefault(arr[i] - difference, 0) + 1;
            dp.put(arr[i], len);
            lenMax = Math.max(len, lenMax);
        }
        return lenMax;
    }
}
