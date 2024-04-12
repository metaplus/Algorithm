package problem.math;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Lc9IsPalindromeTest {

    @Test
    void isPalindrome() {
        assertTrue(new Lc9IsPalindrome().isPalindrome(1410110141));
        assertFalse(new Lc9IsPalindrome().isPalindrome(10));
        assertTrue(new Lc9IsPalindrome().isPalindrome(121));
    }
}