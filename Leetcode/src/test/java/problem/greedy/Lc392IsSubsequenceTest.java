package problem.greedy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Lc392IsSubsequenceTest {

    @Test
    void isSubsequence() {
        assertFalse(new Lc392IsSubsequence().isSubsequence("axc", "ahbgdc"));
        assertTrue(new Lc392IsSubsequence().isSubsequence("abc", "ahbgdc"));
    }
}