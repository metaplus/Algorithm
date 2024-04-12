package problem.dp.sequence;

public class Lc516LongestPalindromeSubseq {

    public int longestPalindromeSubseq(String s) {
        int lenMax = 1;
        char[] chars = s.toCharArray();
        int[][] dp = new int[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = 1;
        }
        for (int i = dp.length - 2; i >= 0; i--) {
            for (int j = i + 1; j < dp.length; j++) {
                if (chars[i] == chars[j]) {
                    if (j - i <= 2) {
                        dp[i][j] = j - i + 1;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1] + 2;
                    }
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
                lenMax = Math.max(lenMax, dp[i][j]);
            }
        }
        return lenMax;
    }
}
