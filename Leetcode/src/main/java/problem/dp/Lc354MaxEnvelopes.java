package problem.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Lc354MaxEnvelopes {


    public int maxEnvelopes(int[][] envelopes) {
        if (Objects.isNull(envelopes)
                || envelopes.length == 0) {
            return 0;
        }
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(b[1], a[1]);
        });
        List<int[]> list = new ArrayList<>();
        list.add(envelopes[0]);
        for (int i = 1; i < envelopes.length; i++) {
            if (envelopes[i][1] > list.get(list.size() - 1)[1]) {
                list.add(envelopes[i]);
                continue;
            }
            int left = 0;
            int right = list.size() - 1;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (list.get(mid)[1] < envelopes[i][1]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            list.set(left, envelopes[i]);
        }
        return list.size();
    }

    // tle
    public int maxEnvelopes2(int[][] envelopes) {
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
