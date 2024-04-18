package problem.dp.sequence;

public class Lc91NumDecodings {

    public int numDecodings(String s) {
        char[] chars = s.toCharArray();
        int[] dp = new int[chars.length + 1];
        dp[0] = 1;
        for (int i = 1; i <= chars.length; i++) {
            if (chars[i - 1] != '0') {
                dp[i] += dp[i - 1];
            }
            if (i - 2 >= 0) {
                if (chars[i - 2] == '1'
                        || (chars[i - 2] == '2' && chars[i - 1] < '7')) {
                    dp[i] += dp[i - 2];
                }
            }
        }
        return dp[chars.length];
    }
}
