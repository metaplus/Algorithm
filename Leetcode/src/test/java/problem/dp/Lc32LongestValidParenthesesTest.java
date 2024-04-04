package problem.dp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Lc32LongestValidParenthesesTest {

    @Test
    void longestValidParentheses() {
        assertEquals(6,new Lc32LongestValidParentheses().longestValidParentheses("(()())"));
        assertEquals(2,new Lc32LongestValidParentheses().longestValidParentheses("()"));
        assertEquals(4,new Lc32LongestValidParentheses().longestValidParentheses(")()())"));
        assertEquals(6,new Lc32LongestValidParentheses().longestValidParentheses("()(())"));
        assertEquals(2,new Lc32LongestValidParentheses().longestValidParentheses("()(()"));
        assertEquals(2,new Lc32LongestValidParentheses().longestValidParentheses("(()"));
    }
}