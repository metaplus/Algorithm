package problem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PalindromeNumberTest {

    @Test
    void isPalindrome() {
        assertTrue(new PalindromeNumber().isPalindrome(121));
        assertFalse(new PalindromeNumber().isPalindrome(123));
    }
}