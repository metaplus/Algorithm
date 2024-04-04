package problem.dp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Lc5LongestPalindromeTest {

    @Test
    void longestPalindrome() {
        assertEquals("aba",new Lc5LongestPalindrome().longestPalindrome("babad"));
    }
}