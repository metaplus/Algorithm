package problem.search.dfs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Lc10IsMatchTest {

    @Test
    void isMatch() {
        assertFalse(new Lc10IsMatch().isMatch("a", "ab*a"));
        assertTrue(new Lc10IsMatch().isMatch("a", "ab*"));
        assertTrue(new Lc10IsMatch().isMatch("mississippi", "mis*is*ip*."));
        assertTrue(new Lc10IsMatch().isMatch("aab", "c*a*b"));
        assertFalse(new Lc10IsMatch().isMatch("aa", "a"));
        assertTrue(new Lc10IsMatch().isMatch("ab", ".*"));
        assertTrue(new Lc10IsMatch().isMatch("aa", "a*"));
    }
}