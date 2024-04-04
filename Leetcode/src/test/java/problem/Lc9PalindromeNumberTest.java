package problem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Lc9PalindromeNumberTest {

    @Test
    void isPalindrome() {
        assertTrue(new Lc9PalindromeNumber().isPalindrome(121));
        assertFalse(new Lc9PalindromeNumber().isPalindrome(123));
    }
}