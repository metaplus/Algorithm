package problem.dp;

import java.util.HashMap;
import java.util.Map;

public class Lc1513NumSub {

    private static final int MOD = 1000000000 + 7;

    public int numSub(String s) {
        int maxLen = 0;
        char[] charArray = s.toCharArray();
        Map<Integer, Integer> rangeCount = new HashMap<>();
        for (int i = 0; i < charArray.length; ) {
            if (charArray[i] == '0') {
                i++;
                continue;
            }
            int right = i + 1;
            while (right < charArray.length && charArray[right] == '1') {
                right++;
            }
            int len = right - i;
            rangeCount.merge(len, 1, Integer::sum);
            maxLen = Math.max(maxLen, len);
            i = right;
        }
        if (maxLen == 0) {
            return 0;
        }
        long[] dp = countDp(maxLen);
        long sum = 0;
        for (Map.Entry<Integer, Integer> range : rangeCount.entrySet()) {
            sum += range.getValue() * dp[range.getKey()];
        }
        return (int) (sum % MOD);
    }

    private long[] countDp(int len) {
        long[] dp = new long[len + 1];
        for (int i = 1; i <= len; i++) {
            dp[i] = dp[i - 1] + i;
        }
        return dp;
    }
}
