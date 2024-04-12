package problem.dp;

import java.util.Arrays;

public class Lc354MaxEnvelopes {

    // tle
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });
        int[] dp = new int[envelopes.length];
        dp[0] = 1;
        int lenMax = 1;
        for (int i = 1; i < envelopes.length; i++) {
            dp[i] = 1;

//            int left = 0;
//            int right = i - 1;
//            while (left < right) {
//                int mid = (left + right + 1) / 2;
//                if (envelopes[mid][0] >= envelopes[i][0]) {
//                    right = mid - 1;
//
//                } else {
//                    left = mid;
//                }
//            }
            for (int j = 0; j < i; j++) {
                if (envelopes[j][0] >= envelopes[i][0]) {
                    break;
                }
                if (envelopes[j][0] < envelopes[i][0]
                        && envelopes[j][1] < envelopes[i][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    lenMax = Math.max(dp[i], lenMax);
                }
            }
        }
        return lenMax;
    }
}
