package org.argo.algorithm.platform.leetcode.solution.dp;

import org.argo.algorithm.platform.leetcode.annotation.LeetcodeSolution;

@LeetcodeSolution(order = 10)
public class RegularExpressionMatching {
    
    public boolean isMatch(String text, String pattern) {
        boolean[][] dp = new boolean[text.length() + 1][pattern.length() + 1];
        dp[text.length()][pattern.length()] = true;
        for (int i = text.length(); i >= 0; i--) {
            for (int j = pattern.length() - 1; j >= 0; j--) {
                if ('*' == pattern.charAt(j)) {
                    dp[i][j] = false;
                    continue;
                }
                boolean frontMatch = i < text.length()
                        && ('.' == pattern.charAt(j)
                        || text.charAt(i) == pattern.charAt(j));
                if (j + 1 < pattern.length() && '*' == pattern.charAt(j + 1)) {
                    if (dp[i][j + 2]) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = frontMatch && dp[i + 1][j];
                    }
                    continue;
                }
                dp[i][j] = frontMatch && dp[i + 1][j + 1];
            }
        }
        return dp[0][0];
    }
}
