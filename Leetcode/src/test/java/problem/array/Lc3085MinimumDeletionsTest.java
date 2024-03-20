package problem.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc3085MinimumDeletionsTest {

    @Test
    void minimumDeletions() {
        assertEquals(4, new Lc3085MinimumDeletions().minimumDeletions("qbbbbvbbbvqb", 0));
        assertEquals(3, new Lc3085MinimumDeletions().minimumDeletions("yynaayyyy", 1));
        assertEquals(6, new Lc3085MinimumDeletions().minimumDeletions("uzzezzuzenzu", 0));
        assertEquals(2, new Lc3085MinimumDeletions().minimumDeletions("dabdcbdcdcd", 2));
        assertEquals(3, new Lc3085MinimumDeletions().minimumDeletions("aabcaba", 0));
    }
}