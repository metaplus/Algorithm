package problem.dp.sequence;

public class Lc647CountSubstrings {

    public int countSubstrings(String s) {
        char[] chars = s.toCharArray();
        boolean[][] dp = new boolean[chars.length][chars.length];
        int count = chars.length;
        for (int i = 0; i < chars.length; i++) {
            dp[i][i] = true;
        }
        for (int i = dp.length - 2; i >= 0; i--) {
            for (int j = i + 1; j < chars.length; j++) {
                if (chars[i] == chars[j]) {
                    if (i + 1 < j) {
                        dp[i][j] = dp[i + 1][j - 1];
                    } else {
                        dp[i][j] = true;
                    }
                    if (dp[i][j]) {
                        count++;
                    }
                }

            }
        }
        return count;
    }
}
