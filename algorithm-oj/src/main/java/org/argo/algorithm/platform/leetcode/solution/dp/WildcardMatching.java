package org.argo.algorithm.platform.leetcode.solution.dp;

import org.argo.algorithm.platform.leetcode.annotation.LeetcodeSolution;

@LeetcodeSolution(order = 44)
public class WildcardMatching {

    public boolean isMatch(String text, String pattern) {
        if (pattern.isEmpty()) {
            return text.isEmpty();
        }
        boolean[][] dp = new boolean[text.length() + 1][pattern.length() + 1];
        for (int i = text.length(); i >= 0; i--) {
            dp[i][pattern.length()] = i == text.length();
            for (int j = pattern.length() - 1; j >= 0; j--) {
                if ('*' == pattern.charAt(j)) {
                    dp[i][j] = dp[i][j + 1]
                            || (i < text.length() && dp[i + 1][j]);
                    continue;
                }
                dp[i][j] = (i < text.length() && dp[i + 1][j + 1])
                        && (text.charAt(i) == pattern.charAt(j) || '?' == pattern.charAt(j));
            }
        }
        return dp[0][0];
    }
}
