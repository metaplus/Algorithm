package problem.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

class Lc125IsPalindromeTest {

    @Test
    void isPalindrome() {
        assertFalse(new Lc125IsPalindrome().isPalindrome("0P"));
    }
}