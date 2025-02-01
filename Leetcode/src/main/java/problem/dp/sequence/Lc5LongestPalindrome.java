package problem.dp.sequence;

import java.util.Arrays;

public class Lc5LongestPalindrome {

    public String longestPalindrome(String s) {
        if (s.isEmpty()) {
            return s;
        }
        char[] chars = s.toCharArray();
        boolean[][] dp = new boolean[chars.length][chars.length];
        int[] result = new int[]{0, 0};
        for (int i = 0; i < chars.length; i++) {
            dp[i][i] = true;
            for (int j = 0; j < i; j++) {
                if (chars[i] == chars[j]
                        && (i - 1 <= j + 1 || dp[i - 1][j + 1])) {
                    dp[i][j] = true;
                    if (i - j > result[1] - result[0]) {
                        result[0] = j;
                        result[1] = i;
                    }
                }
            }
        }
        return s.substring(result[0], result[1] + 1);
    }

    // fail
    public String longestPalindrome3(String s) {
        if (s.isEmpty()) {
            return s;
        }
        char[] chars = s.toCharArray();
        int[] dp = new int[s.length()];
        int[] pre = new int[s.length()];
        Arrays.fill(dp, 1);
        pre[0] = 1;
        int result = 0;
        for (int i = 1; i < chars.length; i++) {
            pre[i] = 1 + (chars[i - 1] == chars[i] ? pre[i - 1] : 0);
            int left = i - dp[i - 1] - 1;
            if (left >= 0 && chars[left] == chars[i]) {
                dp[i] = dp[i - 1] + 2;
            }
            if (chars[i] == chars[i - 1]) {
                dp[i] = Math.max(dp[i], pre[i]);
            }
            if (i - 2 >= 0 && chars[i] == chars[i - 2]) {
                dp[i] = Math.max(dp[i], 3);
            }
            if (dp[i] > dp[result]) {
                result = i;
            }
        }
        return s.substring(result - dp[result] + 1, result + 1);
    }

    public String longestPalindrome2(String s) {
        char[] chars = s.toCharArray();
        int lenMax = 1;
        int left = 0;
        int right = 0;
        boolean[][] dp = new boolean[chars.length][chars.length];
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }
        for (int i = chars.length - 2; i >= 0; i--) {
            for (int j = i + 1; j < chars.length; j++) {
                dp[i][j] = chars[i] == chars[j] && (i + 1 > j - 1 || dp[i + 1][j - 1]);
                if (dp[i][j]) {
                    if (j - i + 1 > lenMax) {
                        lenMax = j - i + 1;
                        left = i;
                        right = j;
                    }
                }
            }
        }
        return s.substring(left, right + 1);
    }
}
