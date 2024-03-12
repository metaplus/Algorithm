package problem.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc76MinWindowTest {

    @Test
    void minWindow() {
        assertEquals("b", new Lc76MinWindow().minWindow("ab", "b"));
        assertEquals("abbbbbcdd", new Lc76MinWindow().minWindow("aaaaaaaaaaaabbbbbcdd", "abcdd"));
        assertEquals("eca", new Lc76MinWindow().minWindow("cabeca", "cae"));
        assertEquals("ab", new Lc76MinWindow().minWindow("bdab", "ab"));
        assertEquals("BANC", new Lc76MinWindow().minWindow("ADOBECODEBANC", "ABC"));
        assertEquals("ba", new Lc76MinWindow().minWindow("bba", "ab"));
        assertEquals("aa", new Lc76MinWindow().minWindow("aa", "aa"));
        assertEquals("", new Lc76MinWindow().minWindow("a", "aa"));
    }
}