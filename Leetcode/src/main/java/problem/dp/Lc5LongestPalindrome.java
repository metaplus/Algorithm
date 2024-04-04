package problem.dp;

public class Lc5LongestPalindrome {

    public String longestPalindrome(String s) {
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
