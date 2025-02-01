package problem.dp;

import org.junit.jupiter.api.Test;
import problem.dp.sequence.Lc5LongestPalindrome;

import static org.junit.jupiter.api.Assertions.*;

class Lc5LongestPalindromeTest {

    @Test
    void longestPalindrome() {
        assertEquals("ababababababa",new Lc5LongestPalindrome().longestPalindrome("ababababababa"));
        assertEquals("aaaa",new Lc5LongestPalindrome().longestPalindrome("aaaa"));
        assertEquals("ccc",new Lc5LongestPalindrome().longestPalindrome("ccc"));
        assertEquals("bb",new Lc5LongestPalindrome().longestPalindrome("cbbd"));
        assertEquals("bab",new Lc5LongestPalindrome().longestPalindrome("babad"));
    }
}