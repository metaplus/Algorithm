package problem.dp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Lc97IsInterleaveTest {

    @Test
    void isInterleave() {
        assertFalse(new Lc97IsInterleave().isInterleave("db", "b", "cbb"));
        assertTrue(new Lc97IsInterleave().isInterleave("", "", ""));
        assertTrue(new Lc97IsInterleave().isInterleave("aabcc", "dbbca", "aadbbcbcac"));
    }
}