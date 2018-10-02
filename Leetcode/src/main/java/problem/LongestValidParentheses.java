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
                    //int rr = r - offset;
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
}
