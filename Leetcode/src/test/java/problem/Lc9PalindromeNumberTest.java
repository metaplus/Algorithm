package problem;

import org.junit.jupiter.api.Test;
import problem.math.Lc9IsPalindrome;

import static org.junit.jupiter.api.Assertions.*;

class Lc9PalindromeNumberTest {

    @Test
    void isPalindrome() {
        assertTrue(new Lc9IsPalindrome().isPalindrome(121));
        assertFalse(new Lc9IsPalindrome().isPalindrome(123));
    }
}