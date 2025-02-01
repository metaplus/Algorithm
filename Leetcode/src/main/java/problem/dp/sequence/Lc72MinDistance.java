package problem.dp.sequence;

import java.util.Arrays;

public class Lc72MinDistance {

    public int minDistance(String word1, String word2) {
        if (word1.isEmpty()) {
            return word2.length();
        }
        if (word2.isEmpty()) {
            return word1.length();
        }
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE / 2);
        }
        dp[0][0] = 0;
        for (int i = 0; i <= word1.length(); i++) {
            for (int j = 0; j <= word2.length(); j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = Math.max(i, j);
                    continue;
                }
                dp[i][j] = dp[i - 1][j] + 1;
                dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + 1);
                dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1] + (word1.charAt(i - 1) == word2.charAt(j - 1) ? 0 : 1));

            }
            int x = 1;
        }
        return dp[word1.length()][word2.length()];
    }


    public int minDistance3(String word1, String word2) {
        if (word1.isEmpty() || word2.isEmpty()) {
            return Math.max(word1.length(), word2.length());
        }
        char[] chars1 = word1.toCharArray();
        char[] chars2 = word2.toCharArray();
        int[][] dp = new int[chars1.length + 1][chars2.length + 1];
        for (int i = 0; i <= chars1.length; i++) {
            for (int j = 0; j <= chars2.length; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = Math.max(i, j);
                    continue;
                }
                dp[i][j] = Math.min(dp[i][j - 1] + 1, dp[i - 1][j] + 1);
                if (chars1[i - 1] == chars2[j - 1]) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1]);
                    continue;
                }
                dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1] + 1);
            }
        }
        return dp[chars1.length][chars2.length];
    }

    public int minDistance2(String word1, String word2) {
        if (word1.isEmpty() || word2.isEmpty()) {
            return Math.max(word1.length(), word2.length());
        }
        char[] chars1 = word1.toCharArray();
        char[] chars2 = word2.toCharArray();
        int[][] dp = new int[chars1.length][chars2.length];
        for (int i = 0; i < chars1.length; i++) {
            for (int j = 0; j < chars2.length; j++) {
                if (chars1[i] == chars2[j]) {
                    if (i > 0 && j > 0) {
                        dp[i][j] = dp[i - 1][j - 1];
                        dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + 1);
                        dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + 1);
                    } else {
                        dp[i][j] = Math.abs(j - i);
                    }
                    continue;
                }
                if (i > 0 && j > 0) {
                    dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j]) + 1;
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1] + 1);
                } else {
                    if (i > 0) {
                        dp[i][j] = dp[i - 1][j] + 1;
                    } else if (j > 0) {
                        dp[i][j] = dp[i][j - 1] + 1;
                    } else {
                        dp[i][j] = 1;
                    }
                }
            }
        }
        return dp[chars1.length - 1][chars2.length - 1];
    }
}
