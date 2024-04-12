package problem.hashmap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Lc290WordPatternTest {

    @Test
    void wordPattern() {
        assertFalse(new Lc290WordPattern().wordPattern("aaa", "aa aa aa aa"));
        assertFalse(new Lc290WordPattern().wordPattern("abba", "dog dog dog dog"));
        assertTrue(new Lc290WordPattern().wordPattern("abba", "dog cat cat dog"));
    }
}