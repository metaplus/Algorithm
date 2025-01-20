package problem.dp;

import java.util.ArrayList;
import java.util.List;

public class Lc2266CountTexts {

    private static final int MOD = 1000_000_007;

    private static long[] createDp(int len, int k) {
        long[] dp = new long[len + 1];
        dp[0] = 1;
        for (int i = 1; i <= len; i++) {
            for (int j = i - 1; j >= i - k && j >= 0; j--) {
                dp[i] += dp[j];
            }
            dp[i] %= MOD;
        }
        return dp;
    }

    public int countTexts(String pressedKeys) {
        int[] counts = new int[10];
        char[] chars = pressedKeys.toCharArray();
        List<Integer> lens = new ArrayList<>(8);
        for (int i = 0; i < chars.length; ) {
            char c = chars[i];
            int len = 1;
            int j = i + 1;
            for (; j < chars.length; j++) {
                if (chars[i] != chars[j]) {
                    break;
                }
                len++;
            }
            counts[c - '0'] = Math.max(counts[c - '0'], len);
            if (chars[i] != '7' && chars[i] != '9') {
                lens.add(len);
            } else {
                lens.add(-len);
            }
            i = j;
        }
        int lenMax3 = 0;
        int lenMax4 = 0;
        for (int i = 0; i < 10; i++) {
            if (i != 7 && i != 9) {
                lenMax3 = Math.max(lenMax3, counts[i]);
                continue;
            }
            lenMax4 = Math.max(lenMax4, counts[i]);
        }
        long[] dp3 = createDp(lenMax3, 3);
        long[] dp4 = createDp(lenMax4, 4);
        long result = 1;
        for (Integer i : lens) {
            result *= i > 0 ? dp3[i] : dp4[-i];
            result %= MOD;
        }
        return (int) result;
    }


}
