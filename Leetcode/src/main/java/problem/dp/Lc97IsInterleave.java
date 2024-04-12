package problem.dp;

public class Lc97IsInterleave {

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        char[] chars3 = s3.toCharArray();
        boolean[][] dp = new boolean[chars1.length + 1][chars2.length + 1];
        for (int i = 0; i <= chars1.length; i++) {
            for (int j = 0; j <= chars2.length; j++) {
                if (i == 0) {
                    if (j == 0) {
                        dp[i][j] = true;
                        continue;
                    }
                    dp[i][j] = chars3[i + j - 1] == chars2[j - 1] && dp[i][j - 1];
                    continue;
                }
                if (j == 0) {
                    dp[i][j] = chars3[i + j - 1] == chars1[i - 1] && dp[i - 1][j];
                    continue;
                }
                dp[i][j] = (chars3[i + j - 1] == chars1[i - 1] && dp[i - 1][j])
                        || (chars3[i + j - 1] == chars2[j - 1] && dp[i][j - 1]);
            }
        }
        return dp[chars1.length][chars2.length];
    }
}
