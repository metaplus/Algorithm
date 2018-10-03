package problem;

import annotation.Problem;

@Problem(
        index = 32,
        solution = LongestValidParentheses.class,
        description = "Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) "
                + "parentheses substring.\n"
                + "\n"
                + "Example 1:\n"
                + "\n"
                + "Input: \"(()\"\n"
                + "Output: 2\n"
                + "Explanation: The longest valid parentheses substring is \"()\"\n"
                + "Example 2:\n"
                + "\n"
                + "Input: \")()())\"\n"
                + "Output: 4\n"
                + "Explanation: The longest valid parentheses substring is \"()()\"\n"
)
public class LongestValidParentheses {

    public int solve(String s) {
        if (s != null && !s.isEmpty()) {
            int strLen = s.length();
            int dp[] = new int[strLen + 1];
            int maxLen = 0;
            for (int l = 1; l <= strLen; ++l) {
                if (maxLen > strLen - l) {
                    break;
                }
                if (s.charAt(l - 1) != '(') {
                    continue;
                }
                int pair = 0;
                int right = 0;
                dp[l - 1] = 0;
                for (int r = l; r <= strLen; ++r) {
                    switch (s.charAt(r - 1)) {
                        case '(':
                            dp[r] = dp[r - 1] + 1;
                            break;
                        case ')':
                            dp[r] = dp[r - 1] - 1;
                            ++right;
                            break;
                        default:
                            throw new RuntimeException();
                    }
                    if (dp[r] < 0) {
                        break;
                    } else if (dp[r] == 0) {
                        pair += right;
                        right = 0;
                    }
                }
                maxLen = Integer.max(maxLen, pair * 2);
            }
            return maxLen;
        }
        return 0;
    }

    public int solve2(String s) {
        if (s != null && !s.isEmpty()) {
            int strLen = s.length();
            int dp[] = new int[strLen];
            int maxLen = 0;
            for (int i = 1; i < strLen; ++i) {
                if (s.charAt(i) == ')') {
                    if (s.charAt(i - 1) == '(') {
                        dp[i] = 2 + (i >= 2 ? dp[i - 2] : 0);
                    } else if (i - dp[i - 1] - 1 >= 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                        dp[i] = dp[i - 1] + 2 +
                                (i - dp[i - 1] - 2 >= 0 ? dp[i - dp[i - 1] - 2] : 0);
                    }
                    maxLen = Math.max(maxLen, dp[i]);
                }
            }
            return maxLen;
        }
        return 0;
    }
}
