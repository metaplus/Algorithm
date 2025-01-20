package problem.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc76MinWindowTest {

    @Test
    void minWindow() {
        assertEquals("abbbbbcdd", new Lc76MinWindow().minWindow("aaaaaaaaaaaabbbbbcdd", "abcdd"));
        assertEquals("BANC", new Lc76MinWindow().minWindow("ADOBECODEBANC", "ABC"));
        assertEquals("b", new Lc76MinWindow().minWindow("ab", "b"));
        assertEquals("", new Lc76MinWindow().minWindow("a", "b"));
        assertEquals("a", new Lc76MinWindow().minWindow("a", "a"));
        assertEquals("ab", new Lc76MinWindow().minWindow("bdab", "ab"));
        assertEquals("eca", new Lc76MinWindow().minWindow("cabeca", "cae"));
        assertEquals("ba", new Lc76MinWindow().minWindow("bba", "ab"));
        assertEquals("aa", new Lc76MinWindow().minWindow("aa", "aa"));
        assertEquals("", new Lc76MinWindow().minWindow("a", "aa"));
    }
}